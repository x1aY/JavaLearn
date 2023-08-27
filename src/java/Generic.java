import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Generic {

    Gson gson = new Gson();

    public class Result<T> {
        public int code;
        public String msg;
        public T data;

        @Override
        public String toString() {
            return "code:" + code + ", msg:" + msg + ", data: " + data.toString();
        }
    }

    public static void main(String[] args) {
        Generic g = new Generic();
        // 泛型数组
        GenericArray geArray = g.new GenericArray();
        geArray.testList();

        String json = "{\"code\":200,\"msg\":\"success\",\"data\":\"data from server\"}";

        // Gson 获取泛型参数类型的TypeToken的写法
        GsonTypeToken gToken = g.new GsonTypeToken();
        gToken.gsonTypeToken(json);

        // 基于 ParameterizedType 获取泛型参数类型
        CustomTypeToken cToken = g.new CustomTypeToken();
        cToken.customTypeToken(json);
    }

    class GenericArray {
        /**
         * T[] 泛型数组
         */
        @SuppressWarnings("unchecked")
        public <T> T[] ArrayWithType(Class<T> type, int size) {
            return (T[]) Array.newInstance(type, size);
        }

        /**
         * List<?> 泛型数组
         */
        public List<?>[] genericList(int size) {
            return new List<?>[size];
        }

        /**
         * List<?> 类型测试
         */
        public void testList() {
            int size = 5;
            ArrayWithType(Result.class, size);

            List<?>[] lists = genericList(size);
            lists[0] = new LinkedList<>(Arrays.asList("abc"));
            lists[1] = new ArrayList<>(Arrays.asList(123));
            lists[2] = Arrays.asList(1.2345);
            for (List<?> list : lists) {
                if (list != null) {
                    System.out.println(list.getClass().getName());
                    System.out.println(list.get(0));
                }
            }
        }

    }

    class GsonTypeToken {

        /**
         * gson TypeToken如何获取
         * https://www.jianshu.com/p/c820e55d9f27
         * Gson解析时TypeToken<T>的泛型参数只能使用时传入确切的类型才能获取正确的Type,
         * 这也是TypeToken设计成抽象类的巧妙之处和原因（改为只有protected构造方法的普通类原理一样）.
         * 一旦将TypeToken改成普通类, 根据上面的分析, 一切类型信息都被擦除, Gson解析将得不到预期的类型
         */
        public void gsonTypeToken(String json) {

            // Gson：
            TypeToken<Result<String>> gsToken = new TypeToken<Result<String>>() {
            };
            Type gsonType = gsToken.getType();
            System.out.println(gson.fromJson(json, gsonType).toString());

            /**
             * 创建匿名类，自动调用无参构造方法，相当于：
             * class MyTypeToken$0 extends MyTypeToken<String>{}
             * MyTypeToken<String> sToken = new MyTypeToken$0();
             */
            MyTypeToken<Result<String>> myTypeToken = new MyTypeToken<Result<String>>() {
            };
            Type mType = myTypeToken.getType();
            System.out.println(mType.getTypeName() +
                    ", equals with gson Type:" + mType.getTypeName().equals(gsonType.getTypeName()));
        }

        public abstract class MyTypeToken<T> {

            // blank final variable，必须在构造器中初始化，或者调用 this() 初始化
            private final Type type;

            public MyTypeToken() {
                Type absClsType = getClass().getGenericSuperclass();
                if (absClsType instanceof Class)
                    throw new RuntimeException("Missing type parameter.");
                ParameterizedType pType = (ParameterizedType) absClsType;
                type = pType.getActualTypeArguments()[0];
            }

            public Type getType() {
                return type;
            }
        }

    }

    class CustomTypeToken {

        public void customTypeToken(String json) {
            // Result<obj>
            Type gsonType1 = new TypeToken<Result<String>>() { }.getType();
            System.out.println(gson.fromJson(json, gsonType1).toString());

            Type mType1 = fromJsonObject(Result.class, String.class);
            System.out.println(mType1.getTypeName());

            // Result<List<obj>>
            TypeToken<Result<List<String>>> gsToken2 = new TypeToken<Result<List<String>>>() { };
            Type gsonType2 = gsToken2.getType();
            System.out.println("gson Type: "+gsonType2.getTypeName());

            Type mType2 = fromJsonArray(Result.class, String.class);
            System.out.println(mType2.getTypeName());
        }

        public <R,T> Type fromJsonObject(Class<R> wrapCls, Class<T> inCls) {
            return new ParamTypeImpl(wrapCls, new Class[] { inCls });
        }

        public <R,T> Type fromJsonArray(Class<R> wrapCls, Class<T> inCls) {
            Type listType = new ParamTypeImpl(List.class, new Class[] { inCls });
            return new ParamTypeImpl(wrapCls, new Type[] { listType });
        }

        public class ParamTypeImpl implements ParameterizedType {
            private final Type raw;
            private final Type[] args;

            public ParamTypeImpl(Type raw, Type[] args) {
                this.raw = raw;
                this.args = args != null ? args : new Type[0];
            }

            @Override
            public Type[] getActualTypeArguments() {
                return args;
            }

            @Override
            public Type getRawType() {
                return raw;
            }

            @Override
            public Type getOwnerType() {
                return null;
            }
        }
    }
}
