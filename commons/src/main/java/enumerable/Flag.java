package enumerable;

public enum Flag {
  US("us"),
  UK("en"),
  CN("cn"),
  FR("fr"),
  KR("kr"),
  JP("jp"),
  DE("de"),
  RU("ru");
//'en',
//  'en-US',
//  'vi',
//  'zh',
//  'es',
//  'de',
//  'ru',
//  'fr',
//  'ko',
//  'jp',
//  'it',
//  'se'
  private final String flg;

  Flag(String name) {
    this.flg = name;
  }

  public String getFlg() {
    return this.flg;
  }

}
