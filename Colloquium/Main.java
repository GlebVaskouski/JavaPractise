import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Store st = new Store();
        st.enteringDataFromFile("D:\\PP last projects\\Shoestore\\src\\in.txt");

        System.out.println("Вывод после ввода:");
        st.cOutput();
        System.out.println("\n\n");

        //Запись в файл
        st.fOutput("D:\\PP last projects\\Shoestore\\src\\out.txt");

        System.out.println("Сортируем по названию обуви и выводим:");
        st.SortByShoeName();
        st.cOutput();
        System.out.println("\n\n");

        System.out.println("Ищем не существующую обувь и выводим результат:");
        System.out.println(st.binarySearchByShoeName("ABC") + "\n\n");

        System.out.println("Ищем обувь с названием \"Air\" и выводим результат:");
        System.out.println(st.binarySearchByShoeName("\"Air\"") + "\n\n");

        System.out.println("Сортируем по возрастанию цен и выводим:");
        st.SortByPriceAscending();
        st.cOutput();
        System.out.println("\n\n");

        System.out.println("Ищем обувь 2022 года и выводим:");
        st.cOutArrayListWithShoes(st.FilterByYear(2022));
        System.out.println("\n\n");

        System.out.println("Группируем обувь по годам и выводим:");
        st.cOutMapByYearWithShoes(st.groupByYear());
        System.out.println("\n\n");
    }

}
