package Homework2;

public class Massive {
    int massSum;
    public void mass(int sizeA, int sizeB) throws MyArraySizeException, MyArrayDataException {

        String[][] mass = new String[][]{
                {"4", "3", "5", "500"},
                {"56", "4", "90", "50"},
                {"9", "69", "34", "9"},
                {"77", "8", "4", "5"}
        };

        if(mass.length != sizeA) throw new MyArraySizeException( "Массив создан не корректно. " +
                "Допускается массив размером: " + sizeA + " X " + sizeB + ".");
        for (int i = 0; i < mass.length; i++) {
            if (mass[i].length != sizeB) throw new MyArraySizeException("Массив создан не корректно. " +
                    "Допускается массив размером: " + sizeA + " X " + sizeB + ".");
        }
        System.out.println("Созданный массив корректен.");

        for (int a = 0; a < mass.length; a++) {
            for (int b = 0; b < mass[a].length; b++) {

                try {
                    massSum += Integer.parseInt(mass[a][b]);
                } catch (MyArrayDataException dataException) {
                    throw new MyArrayDataException("Неверное значение : \"" + mass[a][b] + "\" " +
                            "в ячейке: " + "["+ a + "]["+ b + "].");
                }
            }
        }
        System.out.println("Сумма чисел массива = " + massSum);
    }
}
