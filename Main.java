class GFG {

    // Размерность входной квадратной матрицы

    static final int N = 2;


    // Функция для получения сомножителя

    // mat[p][q] in temp[][]. n is

    // текущий размер матрицы[][]

    static void getCofactor(int mat[][], int temp[][],

                            int p, int q, int n)

    {

        int i = 0, j = 0;


        // Зацикливание для каждого элемента

        // из матрицы

        for (int row = 0; row < n; row++) {

            for (int col = 0; col < n; col++) {

                // Копирование во временную матрицы

                // только те элементы которые являются

                // не в данной строке и столбце

                if (row != p && col != q) {

                    temp[i][j++] = mat[row][col];

                    // Строка заполнена ,поэтому увеличиваем

                    // индекс строки и сброс индекса столбца

                    if (j == n - 1) {

                        j = 0;

                        i++;

                    }

                }

            }

        }

    }


    /* Рекурсивная функция для нахождения определителя

    из матрицы. n - текущее измерение матрицы [][]. */

    static int determinantOfMatrix(int mat[][], int n)

    {

        int D = 0; // Initialize result


        // Base case : if matrix

        // содержит один элемент

        if (n == 1)

            return mat[0][0];


        // Для хранения сомножителя

        int temp[][] = new int[N][N];


        // Для сохранения знака множителя

        int sign = 1;


        // Повторитель для каждого элемента первой строки

        for (int f = 0; f < n; f++) {

            // Получение множителя из матрицы [0][f]

            getCofactor(mat, temp, 0, f, n);

            D += sign * mat[0][f]

                    * determinantOfMatrix(temp, n - 1);

            sign = -sign;

        }

        return D;

    }


    /* Функция для отображения матрицы */

    static void display(int mat[][], int row, int col)

    {

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++)

                System.out.print(mat[i][j]);


            System.out.print("\n");

        }

    }


    // Кода драйвера

    public static void main(String[] args)

    {


        int mat[][] = { { 1, 3, 2, 5, 0, 2, -1 },
                        { 2, 1, 4, 3, 0, 0, 5 },
                        { 4, 6, 7, 2, 1, 4, -3 },
                        { -2, 4, 5, 1, 0, 5, 0 },
                        { 4, 1, 1, 2, 1, 4, -3 },
                        { 5, 3, 2, 2, 1, 4, -6 },
                        { 1, 1, 2, 2, 1, 4, 8 }};


        System.out.print("Determinant "

                + "of the matrix is : "

                + determinantOfMatrix(mat, N));

    }
}