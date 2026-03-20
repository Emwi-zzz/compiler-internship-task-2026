public class MiniProgram {
    public static void factorial(Integer __function_parameter_n, Continuation<Integer> __continuation) {
        Integer[] n = new Integer[]{ __function_parameter_n };

        if(n[0] <= 1)
        {
            __continuation.accept(1);
            return;

        }
        else {
            factorial(n[0] - 1, (__result0) -> {
                __continuation.accept(n[0] * __result0);
                return;

            });
        }
        ;

    }


    public static void main(String[] args) {

        factorial(5, (__result0) -> {
            Integer[] result = new Integer[]{ __result0 };
            Prelude.println(result[0], (__result1) -> {
                ;
                Integer[] a = new Integer[]{ 10 + 5 };
                Boolean[] b = new Boolean[]{ a[0] > 10 };
                Prelude.println(a[0], (__result2) -> {
                    ;

                });
            });
        });
    }



}