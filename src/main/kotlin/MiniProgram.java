public class MiniProgram {
    public static void getLimit(Integer __function_parameter_current, Continuation<Integer> __continuation) {
        Integer[] current = new Integer[]{ __function_parameter_current };
        __continuation.accept(current[0] + 2);
        return;
    }


    public static void shouldContinue(Integer __function_parameter_i, Integer __function_parameter_max, Continuation<Boolean> __continuation) {
        Integer[] i = new Integer[]{ __function_parameter_i };
        Integer[] max = new Integer[]{ __function_parameter_max };
        __continuation.accept(i[0] < max[0]);
        return;
    }


    public static void main(String[] args) {
        Integer[] i = new Integer[]{ 0 };
        Integer[] total = new Integer[]{ 0 };
        Integer[] limit = new Integer[]{ 10 };
        getLimit(limit[0], (__result0) -> {
            shouldContinue(i[0], __result0, (__result1) -> {
                while (__result1){
                    {total[0] = total[0] + i[0];
                        ;
                        i[0] = i[0] + 1;
                        ;
                        if (i[0] == 5){
                            {Prelude.println("Halfway", (__result2) -> {
                                ;
                            });
                            }
                        }
                        ;
                    }
                }
                ;
                ;
                ;
                ;
                ;
            });
        });
    }



}