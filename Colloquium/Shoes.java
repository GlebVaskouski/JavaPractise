public class Shoes {
    String shoeName;       //Название обуви
    String companyName;    //Название фирмы
    String dateOfDelivery; //Дата поставки
    int month;             //Месяц
    int year;              //Год
    int numberOfPairs;     //Количество пар
    double price;          //Стоимость

    public Shoes(String shoeName, String companyName, String dateOfDelivery, int month, int year, int numberOfPairs, double price) {
        this.shoeName = shoeName;
        this.companyName = companyName;
        this.dateOfDelivery = dateOfDelivery;
        this.month = month;
        this.year = year;
        this.numberOfPairs = numberOfPairs;
        this.price = price;
    }

    public Shoes() {
        this.shoeName = "NO";
        this.companyName = "NO";
        this.dateOfDelivery = "NO";
        this.month = 0;
        this.year = 0;
        this.numberOfPairs = 0;
        this.price = 0;
    }

    public String getShoeName() {
        return shoeName;
    }

    public void setShoeName(String shoeName) {
        this.shoeName = shoeName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDateOfDelivery() {
        return dateOfDelivery;
    }

    public void setDateOfDelivery(String dateOfDelivery) {
        this.dateOfDelivery = dateOfDelivery;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumberOfPairs() {
        return numberOfPairs;
    }

    public void setNumberOfPairs(int numberOfPairs) {
        this.numberOfPairs = numberOfPairs;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shoes shoes = (Shoes) o;

        if (!getShoeName().equals(shoes.getShoeName())) return false;
        return getCompanyName().equals(shoes.getCompanyName());
    }

    @Override
    public int hashCode() {
        int result = getShoeName().hashCode();
        result = 31 * result + getCompanyName().hashCode();
        return result;
    }

    /*@Override
    public String toString() {
        return "Обувь{" +
                "Название пары = '" + shoeName + '\'' +
                ", Название компании = '" + companyName + '\'' +
                ", Дата поступления = '" + dateOfDelivery + '\'' +
                ", Количество пар = " + numberOfPairs +
                ", Стоимость = " + price +
                '}';
    }*/

/*    @Override
    public String toString() {
        return "Shoes{" +
                "Shoes name = '" + shoeName + '\'' +
                ", Company name = '" + companyName + '\'' +
                ", Receipt date = '" + dateOfDelivery + '\'' +
                ", Number of pairs = " + numberOfPairs +
                ", Price = " + price +
                '}';
    }*/

    @Override
    public String toString() {
        return "Shoes{" + shoeName +
                ", " + companyName +
                ", " + dateOfDelivery +
                ", " + numberOfPairs +
                ", " + price +
                '}';
    }
}
