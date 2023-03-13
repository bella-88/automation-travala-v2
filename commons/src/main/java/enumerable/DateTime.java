package enumerable;

public class DateTime {
  public enum MyMonthEng {
    Jan(1),
    Feb(2),
    Mar(3),
    Apr(4),
    May(5),
    Jun(6),
    Jul(7),
    Aug(8),
    Sep(9),
    Oct(10),
    Nov(11),
    Dec(12);

    private int month;

    MyMonthEng(int month) {
      this.month = month;
    }

    public int getMonth() {
      return this.month;
    }
  }
  public enum MyMonthEs {
    ene(1),
    feb(2),
    mar(3),
    apr(4),
    may(5),
    jun(6),
    jul(7),
    ago(8),
    sep(9),
    oct(10),
    nov(11),
    dic(12);

    private int month;

    MyMonthEs(int month) {
      this.month = month;
    }

    public int getMonth() {
      return this.month;
    }
  }
  public enum MyMonthFr {
    janv(1),
    févr(2),
    mars (3),
    avr(4),
    mai (5),
    juin (6),
    juil(7),
    août (8),
    sept(9),
    oct(10),
    nov(11),
    déc(12);

    private int month;

    MyMonthFr(int month) {
      this.month = month;
    }

    public int getMonth() {
      return this.month;
    }
  }
  public enum MyMonthDe {
    Jan(1),
    Feb(2),
    Mär(3),
    Apr(4),
    Mai(5),
    Juni(6),
    Juli(7),
    Agu(8),
    Sep(9),
    Okt(10),
    Nov(11),
    Dez(12);

    private int month;

    MyMonthDe(int month) {
      this.month = month;
    }

    public int getMonth() {
      return this.month;
    }
  }
  public enum MyMonthRu {
    янв(1),
    фев(2),
    мар(3),
    апр(4),
    мая(5),
    июн(6),
    июл(7),
    авг(8),
    сент(9),
    окт(10),
    нояб(11),
    дек(12);

    private int month;

    MyMonthRu(int month) {
      this.month = month;
    }

    public int getMonth() {
      return this.month;
    }
  }

}



