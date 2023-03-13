package pages.hotel.footer.support;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;


import commons.hotel.CommonHotelPages;
import static interfaces.hotel.footer.support.HelpCenterPageUI.*;
public class HelpCenterPage extends CommonHotelPages {
  WebDriver driver;

  public HelpCenterPage(WebDriver driver_) {
    this.driver = driver_;
    super.setDriver(driver);
  }

  public void verifyHelpPage() {
    String[] content = {"HELP_BANNER_TITLE", "HELP_BROWSE_HELP_TOPIC_TXT", "HELP_CONTENT2_TITLE", "HELP_CONTENT2_SUB_TITLE", "HELP_CONTACT_US_BTN", "HELP_MAIN_LINK1", "HELP_MAIN_LINK2",};
    String[] xpath = {HELP_BANNER_TITLE, HELP_BROWSE_HELP_TOPIC_TXT, HELP_CONTENT2_TITLE, HELP_CONTENT2_SUB_TITLE, HELP_CONTACT_US_BTN, HELP_MAIN_LINK1, HELP_MAIN_LINK2};
    wait100Time();
    boolean a = StringUtils.contains(getAttribute(driver, HELP_BANNER_TEXT_HOLDER, "placeholder"), getTextFromReadFile("HELP_BANNER_TEXT_HOLDER"));
    try {
      if (verifyTwoListByKey(content, xpath) && a) {
        System.out.println("HELP Page is displayed correct");
      } else {
        System.out.println("HELP Page is displayed wrong");
      }
    } catch (org.openqa.selenium.NoSuchElementException e) {
      System.out.println(e.getMessage());
    }
  }

  public void verifyListCommon() {
    wait100Time();
    String[] titleQuestion = {"HELP_COMMON_QUESTION1", "HELP_COMMON_QUESTION2", "HELP_COMMON_QUESTION3", "HELP_COMMON_QUESTION5", "HELP_COMMON_QUESTION7",
      "HELP_COMMON_QUESTION9", "HELP_COMMON_QUESTION10", "HELP_COMMON_QUESTION11", "HELP_COMMON_QUESTION12", "HELP_COMMON_QUESTION14", "HELP_COMMON_QUESTION16"};
    if (verifyListTitleQuestion(titleQuestion, "HELP_MENU_COMMON_QUESTION")) {
      System.out.println("Question at List Common is displayed correct");
    } else {
      System.out.println("Question at List Common is displayed wrong");
    }
  }

  //=======================VERIFY CONTENT STAY MENU===================================
  public void verifyListMakingHotelQuestion() {
    waitFoElementVisible(driver,HELP_MENU_SUB1 );
    clickToElementByJavascript(driver, HELP_MENU_SUB1);
    wait100Time();
    String[] titleQuestion = {"HELP_COMMON_QUESTION1", "HELP_MAKING_HOTEL_QUESTION2", "HELP_MAKING_HOTEL_QUESTION1", "HELP_MAKING_HOTEL_QUESTION3", "HELP_MAKING_HOTEL_QUESTION4",
      "HELP_MAKING_HOTEL_QUESTION8", "HELP_MAKING_HOTEL_QUESTION5", "HELP_MAKING_HOTEL_QUESTION6", "HELP_MAKING_HOTEL_QUESTION7"};
    boolean title = verifyListTitleQuestion(titleQuestion, "HELP_MENU_MAKING_RESERVATION");
    String[] answers = {"HELP_MAKING_HOTEL_ANSWERS1", "HELP_MAKING_HOTEL_ANSWERS2", "HELP_MAKING_HOTEL_ANSWERS3", "HELP_MAKING_HOTEL_ANSWERS4", "HELP_MAKING_HOTEL_ANSWERS5",
      "HELP_MAKING_HOTEL_ANSWERS6", "HELP_MAKING_HOTEL_ANSWERS7", "HELP_MAKING_HOTEL_ANSWERS8", "HELP_MAKING_HOTEL_ANSWERS9"};
    if (title && verifyListAnswersFAQ(answers, "HELP_MENU_MAKING_RESERVATION", HELP_MENU_SUB1)) {
      System.out.println("Making Hotel at Stays is displayed correct");
    } else {
      System.out.println("Making Hotel at Stays is displayed wrong");
    }
  }

  public void verifyListBookingAmendmentQuestion() {
    clickToElementByJavascript(driver, HELP_MENU_SUB2);
    wait100Time();
    String[] titleQuestion = {"HELP_BOOKING_AMENDMENT_QUESTION1", "HELP_BOOKING_AMENDMENT_QUESTION2", "HELP_BOOKING_AMENDMENT_QUESTION3", "HELP_COMMON_QUESTION2"};
    boolean title = verifyListTitleQuestion(titleQuestion, "HELP_MENU_MY_BOOKING");
    String[] answers = {"HELP_BOOKING_AMENDMENT_ANSWERS1", "HELP_BOOKING_AMENDMENT_ANSWERS2", "HELP_BOOKING_AMENDMENT_ANSWERS3", "HELP_BOOKING_AMENDMENT_ANSWERS4"};
    if (title && verifyListAnswersFAQ(answers, "HELP_MENU_MY_BOOKING", HELP_MENU_SUB2)) {
      System.out.println("Booking Amendment at Stays is displayed correct");
    } else {
      System.out.println("Booking Amendment at Stays is displayed wrong");
    }
  }

  public void verifyListCancelQuestion() {
    clickToElementByJavascript(driver, HELP_MENU_SUB3);
    wait100Time();
    String[] titleQuestion = {"HELP_CANCEL_QUESTION1", "HELP_CANCEL_QUESTION4", "HELP_CANCEL_QUESTION2", "HELP_CANCEL_QUESTION3", "HELP_CANCEL_QUESTION1"};
    boolean title = verifyListTitleQuestion(titleQuestion, "HELP_MENU_CANCELLATION");
    wait100Time();
    String[] answers = {"HELP_CANCEL_QUESTION1_CONTENT", "HELP_CANCEL_QUESTION2_CONTENT", "HELP_CANCEL_QUESTION3_CONTENT", "HELP_CANCEL_QUESTION4_CONTENT"};
    if (title && verifyListAnswersFAQ(answers, "HELP_MENU_CANCELLATION", HELP_MENU_SUB3)) {
      System.out.println("Cancellation at Stays is displayed correct");
    } else {
      System.out.println("Cancellation at Stays is displayed wrong");
    }
  }

  public void verifyListPaymentQuestion() {
    clickToElementByJavascript(driver, HELP_MENU_SUB4);
    wait200Time();
    String[] titleQuestion = {"HELP_COMMON_QUESTION3", "HELP_PAYMENT_REFUND_QUESTION2", "HELP_PAYMENT_REFUND_QUESTION3", "HELP_PAYMENT_REFUND_QUESTION4", "HELP_COMMON_QUESTION5"};
    boolean title = verifyListTitleQuestion(titleQuestion, "HELP_MENU_PAYMENTS");
    String[] answers = {"HELP_PAYMENT_QUESTION1_CONTENT", "HELP_PAYMENT_QUESTION2_CONTENT", "HELP_PAYMENT_QUESTION3_CONTENT", "HELP_PAYMENT_QUESTION4_CONTENT"};
    if (title && verifyListAnswersFAQ(answers, "HELP_MENU_PAYMENTS", HELP_MENU_SUB4)) {
      System.out.println("Payment at Stays is displayed correct");
    } else {
      System.out.println("Payment at Stays is displayed wrong");
    }
  }

  public void verifyListListingRequestQuestion() {
    clickToElementByJavascript(driver, HELP_MENU_SUB5);
    wait100Time();
    String[] titleQuestion = {"HELP_LISTING_REQUEST_QUESTION"};
    boolean title = verifyListTitleQuestion(titleQuestion, "HELP_MENU_LISTING_REQUEST");
    String[] answers = {"HELP_LISTING_QUESTION_CONTENT"};
    if (title && verifyListAnswersFAQ(answers, "HELP_MENU_LISTING_REQUEST", HELP_MENU_SUB5)) {
      System.out.println("Listing Request at Stays is displayed correct");
    } else {
      System.out.println("Listing Request at Stays is displayed wrong");
    }
  }

  public void verifyStayMenu() {
    clickToElementByJavascript(driver, HELP_MENU_STAYS);
    wait100Time();
    String[] content = {"HELP_MENU_MAKING_RESERVATION", "HELP_MENU_MY_BOOKING", "HELP_MENU_CANCELLATION", "HELP_MENU_PAYMENTS", "HELP_MENU_STAYS_LISTING"};
    if (!compareTwoListByKey(content, HELP_MENU_LIST)) {
      System.out.println("Stays menu is displayed wrong");
    } else {
      System.out.println("Stays menu is displayed correct");
    }
//    verifyListMakingHotelQuestion();
//    verifyListBookingAmendmentQuestion();
//    verifyListCancelQuestion();
//    verifyListPaymentQuestion();
    verifyListListingRequestQuestion();
    clickToElement(driver, HELP_MENU_STAYS);
    clickToElement(driver, HELP_MENU_STAYS);
//    wait300Time();
  }

  //=======================VERIFY CONTENT FLIGHTS HOTEL===================================
  public void verifyListBookingFlight() {
    wait100Time();
    clickToElementByJavascript(driver, HELP_MENU_SUB1);
    wait100Time();
    String[] titleQuestion = {"HELP_FLIGHT_BOOKING_QUESTION1", "HELP_FLIGHT_BOOKING_QUESTION2", "HELP_FLIGHT_BOOKING_QUESTION3", "HELP_FLIGHT_BOOKING_QUESTION4", "HELP_FLIGHT_BOOKING_QUESTION5",
      "HELP_FLIGHT_BOOKING_QUESTION6", "HELP_FLIGHT_BOOKING_QUESTION7", "HELP_FLIGHT_BOOKING_QUESTION8", "HELP_FLIGHT_BOOKING_QUESTION9", "HELP_FLIGHT_BOOKING_QUESTION10"};
    boolean title = verifyListTitleQuestion(titleQuestion, "HELP_MENU_MY_BOOKING");
    String[] answers = {"HELP_FLIGHT_BOOKING_QUESTION1_CONTENT", "HELP_FLIGHT_BOOKING_QUESTION2_CONTENT", "HELP_FLIGHT_BOOKING_QUESTION3_CONTENT", "HELP_FLIGHT_BOOKING_QUESTION4_CONTENT",
      "HELP_FLIGHT_BOOKING_QUESTION5_CONTENT", "HELP_FLIGHT_BOOKING_QUESTION6_CONTENT", "HELP_FLIGHT_BOOKING_QUESTION7_CONTENT", "HELP_FLIGHT_BOOKING_QUESTION8_CONTENT",
      "HELP_FLIGHT_BOOKING_QUESTION9_CONTENT", "HELP_FLIGHT_BOOKING_QUESTION10_CONTENT"};
    if (title && verifyListAnswersFAQ(answers, "HELP_MENU_MY_BOOKING", HELP_MENU_SUB1)) {
      System.out.println("Booking at Flights is displayed correct");
    } else {
      System.out.println("Booking at Flights is displayed wrong");
    }
  }

  public void verifyListBaggageFlight() {
    clickToElementByJavascript(driver, HELP_MENU_SUB2);
    wait100Time();
    String[] titleQuestion = {"HELP_FLIGHT_BAGGAGE_QUESTION1", "HELP_FLIGHT_BAGGAGE_QUESTION2", "HELP_FLIGHT_BAGGAGE_QUESTION3"};
    boolean title = verifyListTitleQuestion(titleQuestion, "HELP_FLIGHT_BAGGAGE");
    String[] answers = {"HELP_FLIGHT_BAGGAGE_QUESTION1_CONTENT", "HELP_FLIGHT_BAGGAGE_QUESTION2_CONTENT", "HELP_FLIGHT_BAGGAGE_QUESTION3_CONTENT"};
    if (title && verifyListAnswersFAQ(answers, "HELP_FLIGHT_BAGGAGE", HELP_MENU_SUB2)) {
      System.out.println("Baggage at Flights is displayed correct");
    } else {
      System.out.println("Baggage at Flights is displayed wrong");
    }
  }

  public void verifyListCancelRefundFlight() {
    clickToElementByJavascript(driver, HELP_MENU_SUB3);
    wait100Time();
    String[] titleQuestion = {"HELP_FLIGHT_CANCEL_QUESTION1", "HELP_FLIGHT_CANCEL_QUESTION3", "HELP_FLIGHT_CANCEL_QUESTION2", "HELP_FLIGHT_CANCEL_QUESTION4"};
    boolean title = verifyListTitleQuestion(titleQuestion, "HELP_FLIGHT_CANCEL");
    String[] answers = {"HELP_FLIGHT_CANCEL_QUESTION1_CONTENT", "HELP_FLIGHT_CANCEL_QUESTION2_CONTENT", "HELP_FLIGHT_CANCEL_QUESTION3_CONTENT",
      "HELP_FLIGHT_CANCEL_QUESTION4_CONTENT"};
    if (title && verifyListAnswersFAQ(answers, "HELP_FLIGHT_CANCEL", HELP_MENU_SUB3)) {
      System.out.println("Cancel Refund at Flights is displayed correct");
    } else {
      System.out.println("Cancel Refund at Flights is displayed wrong");
    }
  }

  public void verifyListChangeBookingFlight() {
    clickToElementByJavascript(driver, HELP_MENU_SUB4);
    wait100Time();
    String[] titleQuestion = {"HELP_FLIGHT_CHANGE_QUESTION1", "HELP_FLIGHT_CHANGE_QUESTION2"};
    boolean title = verifyListTitleQuestion(titleQuestion, "HELP_FLIGHT_CHANGE");
    String[] answers = {"HELP_FLIGHT_CHANGE_QUESTION1_CONTENT", "HELP_FLIGHT_CHANGE_QUESTION2_CONTENT"};
    if (title && verifyListAnswersFAQ(answers, "HELP_FLIGHT_CHANGE", HELP_MENU_SUB4)) {
      System.out.println("Change Booking at Flights is displayed correct");
    } else {
      System.out.println("Change Booking at Flights is displayed wrong");
    }
  }

  public void verifyListTravelSmartProtectionFlight() {
    clickToElementByJavascript(driver, HELP_MENU_SUB5);
    wait100Time();
    String[] titleQuestion = {"HELP_FLIGHT_PAID_QUESTION1", "HELP_FLIGHT_PAID_QUESTION2", "HELP_FLIGHT_PAID_QUESTION3", "HELP_FLIGHT_PAID_QUESTION4",
      "HELP_FLIGHT_PAID_QUESTION5", "HELP_FLIGHT_PAID_QUESTION6", "HELP_FLIGHT_PAID_QUESTION7", "HELP_FLIGHT_PAID_QUESTION8", "HELP_FLIGHT_PAID_QUESTION9"};
    boolean bQuestion = verifyListTitleQuestion(titleQuestion, "HELP_FLIGHT_TRAVEL_SMART_PROTECTION");
    String[] answers = {"HELP_FLIGHT_PAID_CONTENT1", "HELP_FLIGHT_PAID_CONTENT2", "HELP_FLIGHT_PAID_CONTENT3", "HELP_FLIGHT_PAID_CONTENT4",
      "HELP_FLIGHT_PAID_CONTENT5", "HELP_FLIGHT_PAID_CONTENT6", "HELP_FLIGHT_PAID_CONTENT7", "HELP_FLIGHT_PAID_CONTENT8", "HELP_FLIGHT_PAID_CONTENT9"};
    boolean bAnswers = verifyListAnswersFAQ(answers, "HELP_FLIGHT_TRAVEL_SMART_PROTECTION", HELP_MENU_SUB5);
    if (bQuestion && bAnswers) {
      System.out.println("Travel Smart Protection at Flights correct");
    } else {
      System.out.println("Travel Smart Protection at Flights wrong");
    }
  }

  public void verifyListPriorityBoardingFlight() {
    clickToElementByJavascript(driver, HELP_MENU_SUB6);
    wait100Time();
    String[] titleQuestion = {"HELP_FLIGHT_PRIORITY_QUESTION1", "HELP_FLIGHT_PRIORITY_QUESTION2", "HELP_FLIGHT_PRIORITY_QUESTION3", "HELP_FLIGHT_PRIORITY_QUESTION4",
      "HELP_FLIGHT_PRIORITY_QUESTION5","HELP_FLIGHT_PRIORITY_QUESTION9","HELP_FLIGHT_PRIORITY_QUESTION6","HELP_FLIGHT_PRIORITY_QUESTION7","HELP_FLIGHT_PRIORITY_QUESTION8"};
    boolean bQuestion = verifyListTitleQuestion(titleQuestion, "HELP_FLIGHT_PRIORITY_BOARDING");
    String[] answers = {"HELP_FLIGHT_PRIORITY_CONTENT1", "HELP_FLIGHT_PRIORITY_CONTENT2", "HELP_FLIGHT_PRIORITY_CONTENT3", "HELP_FLIGHT_PRIORITY_CONTENT4",
      "HELP_FLIGHT_PRIORITY_CONTENT5","HELP_FLIGHT_PRIORITY_CONTENT6","HELP_FLIGHT_PRIORITY_CONTENT7","HELP_FLIGHT_PRIORITY_CONTENT8","HELP_FLIGHT_PRIORITY_CONTENT9"};
    boolean bAnswers = verifyListAnswersFAQ(answers, "HELP_FLIGHT_PRIORITY_BOARDING", HELP_MENU_SUB6);
    if (bQuestion && bAnswers) {
      System.out.println("Priority Boarding at Flights correct");
    } else {
      System.out.println("Priority Boarding at Flights wrong");
    }
  }

  public void verifyFlightsMenu() {
    wait100Time();
    clickToElementByJavascript(driver, HELP_MENU_FLIGHTS);
    String[] content = {"HELP_MENU_FLIGHTS_BOOKING", "HELP_MENU_FLIGHTS_BAGGAGE", "HELP_MENU_FLIGHTS_CANCEL", "HELP_MENU_FLIGHTS_CHANGE_BOOKING", "HELP_FLIGHT_TRAVEL_SMART_PROTECTION", "HELP_FLIGHT_PRIORITY_BOARDING"};
    if (!compareTwoListByKey(content, HELP_MENU_LIST)) {
      System.out.println("Flights menu is displayed wrong");
    } else {
      System.out.println("Flights menu is displayed correct");
    }
//    verifyListBookingFlight();
//    verifyListBaggageFlight();
//    verifyListCancelRefundFlight();
//    verifyListChangeBookingFlight();
    verifyListTravelSmartProtectionFlight();
    verifyListPriorityBoardingFlight();
    clickToElement(driver, HELP_MENU_FLIGHTS);
    clickToElement(driver, HELP_MENU_FLIGHTS);

  }

  //=======================VERIFY CONTENT ACTIVITIES HOTEL===================================
  public void verifyListBookingActivities() {
    clickToElementByJavascript(driver, HELP_MENU_SUB1);
    wait100Time();
    String[] titleQuestion = {"HELP_ACTIVITIES_BOOKING_QUESTION1", "HELP_ACTIVITIES_BOOKING_QUESTION2", "HELP_ACTIVITIES_BOOKING_QUESTION3", "HELP_ACTIVITIES_BOOKING_QUESTION4", "HELP_ACTIVITIES_BOOKING_QUESTION5",
      "HELP_ACTIVITIES_BOOKING_QUESTION6", "HELP_ACTIVITIES_BOOKING_QUESTION7", "HELP_ACTIVITIES_BOOKING_QUESTION8"};
    boolean title = verifyListTitleQuestion(titleQuestion, "HELP_MENU_FLIGHTS_BOOKING");
    String[] answers = {"HELP_ACTIVITIES_BOOKING_QUESTION1_CONTENT", "HELP_ACTIVITIES_BOOKING_QUESTION2_CONTENT", "HELP_ACTIVITIES_BOOKING_QUESTION3_CONTENT", "HELP_ACTIVITIES_BOOKING_QUESTION4_CONTENT",
      "HELP_ACTIVITIES_BOOKING_QUESTION5_CONTENT", "HELP_ACTIVITIES_BOOKING_QUESTION6_CONTENT", "HELP_ACTIVITIES_BOOKING_QUESTION7_CONTENT", "HELP_ACTIVITIES_BOOKING_QUESTION8_CONTENT"};
    if (title && verifyListAnswersFAQ(answers, "HELP_MENU_FLIGHTS_BOOKING", HELP_MENU_SUB1)) {
      System.out.println("Booking at Activities is displayed correct");
    } else {
      System.out.println("Booking at Activities is displayed wrong");
    }
  }

  public void verifyListPaymentActivities() {
    clickToElementByJavascript(driver, HELP_MENU_SUB2);
    wait100Time();
    String[] titleQuestion = {"HELP_PAYMENT_REFUND_QUESTION4", "HELP_ACTIVITIES_PAYMENT_QUESTION2", "HELP_ACTIVITIES_PAYMENT_QUESTION3",
      "HELP_ACTIVITIES_PAYMENT_QUESTION4", "HELP_ACTIVITIES_CANCEL_QUESTION5"};
    wait100Time();
    boolean title = verifyListTitleQuestion(titleQuestion, "HELP_MENU_PAYMENTS");
    String[] answers = {"HELP_ACTIVITIES_PAYMENT_QUESTION1_CONTENT", "HELP_ACTIVITIES_PAYMENT_QUESTION2_CONTENT", "HELP_ACTIVITIES_PAYMENT_QUESTION3_CONTENT",
      "HELP_ACTIVITIES_PAYMENT_QUESTION4_CONTENT", "HELP_ACTIVITIES_CANCEL_QUESTION5_CONTENT"};
    if (title && verifyListAnswersFAQ(answers, "HELP_MENU_PAYMENTS", HELP_MENU_SUB2)) {
      System.out.println("Payment at Activities is displayed correct");
    } else {
      System.out.println("Payment at Activities is displayed wrong");
    }
  }

  public void verifyListCancelActivities() {
    clickToElementByJavascript(driver, HELP_MENU_SUB3);
    wait100Time();
    String[] titleQuestion = {"HELP_ACTIVITIES_CANCEL_QUESTION1", "HELP_ACTIVITIES_CANCEL_QUESTION2", "HELP_ACTIVITIES_CANCEL_QUESTION3",
      "HELP_ACTIVITIES_CANCEL_QUESTION4"};
    boolean title = verifyListTitleQuestion(titleQuestion, "HELP_MENU_CANCELLATION");
    String[] answers = {"HELP_ACTIVITIES_CANCEL_QUESTION1_CONTENT", "HELP_ACTIVITIES_CANCEL_QUESTION2_CONTENT", "HELP_ACTIVITIES_CANCEL_QUESTION3_CONTENT",
      "HELP_ACTIVITIES_CANCEL_QUESTION4_CONTENT"};
    if (title && verifyListAnswersFAQ(answers, "HELP_MENU_CANCELLATION", HELP_MENU_SUB3)) {
      System.out.println("Cancel at Activities is displayed correct");
    } else {
      System.out.println("Cancel at Activities is displayed wrong");
    }
  }

  public void verifyActivitiesMenu() {
    clickToElementByJavascript(driver, HELP_MENU_ACTIVITIES);
    wait200Time();
    String[] expect = {"HELP_MENU_FLIGHTS_BOOKING", "HELP_MENU_CANCELLATION", "HELP_MENU_PAYMENTS"};
    if (!compareTwoListByKey(expect, HELP_MENU_LIST)) {
      System.out.println("Activities menu is displayed wrong");
    } else {
      System.out.println("Activities menu is displayed correct");
    }
    verifyListBookingActivities();
    verifyListPaymentActivities();
    verifyListCancelActivities();
    clickToElementByJavascript(driver, HELP_MENU_ACTIVITIES);
    wait200Time();
  }

  //=======================VERIFY LIST QUESTION IN THE HELP PAGE===================================
  public void verifyContentBestPriceQuestion() {
    clickToElementByJavascript(driver, HELP_MENU_BEST_PRICE);
    wait200Time();
    String[] titleQuestion = {"HELP_BEST_PRICE_QUESTION1", "HELP_BEST_PRICE_QUESTION3", "HELP_COMMON_QUESTION9"};
    boolean title = verifyListTitleQuestion(titleQuestion, "MENU_BestPrice");
    String[] answers = {"HELP_BEST_PRICE_CONTENT1", "HELP_BEST_PRICE_CONTENT2", "HELP_BEST_PRICE_CONTENT3"};
    boolean sAnswers = verifyListAnswersFAQ(answers, "MENU_BestPrice", HELP_MENU_BEST_PRICE);
    if (title && sAnswers) {
      System.out.println("List question and answers in best price correct");
    } else {
      System.out.println("List question and answers in best price wrong");
    }
  }

  public boolean verifyContentFlightPaid() {
    clickToElementByJavascript(driver, HELP_MENU_BEST_PRICE);
    wait100Time();
    String[] titleQuestion = {"HELP_BEST_PRICE_QUESTION1", "HELP_BEST_PRICE_QUESTION3", "HELP_COMMON_QUESTION9"};
    boolean title = verifyListTitleQuestion(titleQuestion, "MENU_BestPrice");
    String[] answers = {"HELP_BEST_PRICE_CONTENT1", "HELP_BEST_PRICE_CONTENT2", "HELP_BEST_PRICE_CONTENT3"};
    boolean sAnswers = verifyListAnswersFAQ(answers, "MENU_BestPrice", HELP_MENU_BEST_PRICE);
    return title && sAnswers;
  }

  public void verifyListSmartQuestion() {
    clickToElementByJavascript(driver, HELP_MENU_SMART_PROGRAM);
    wait100Time();
    String[] titleQuestion = {"HELP_SMART_PROGRAM_QUESTION", "HELP_SMART_PROGRAM_QUESTION1", "HELP_COMMON_QUESTION3", "HELP_SMART_PROGRAM_QUESTION2"};
    boolean title = verifyListTitleQuestion(titleQuestion, "MY_SMART_PROGRAM_BANNER");
    String[] answers = {"Smart_ANSWERS1", "Smart_ANSWERS2", "FAQ_SMART_CONTENT", "Smart_ANSWERS4"};
    boolean sAnswers = verifyListAnswersFAQ(answers, "MY_SMART_PROGRAM_BANNER", HELP_MENU_SMART_PROGRAM);
    if (title && sAnswers) {
      System.out.println("List question and answers in smart program correct");
    } else {
      System.out.println("List question and answers in smart program wrong");
    }
  }

  public boolean verifyListInviteQuestion() {
    clickToElementByJavascript(driver, HELP_MENU_INVITE_PROGRAM);
    wait100Time();
    String[] titleQuestion = {"HELP_MENU_INVITE_PROGRAM", "HELP_MENU_INVITE_PROGRAM", "HELP_INVITE_QUESTION1", "HELP_INVITE_QUESTION2",
      "HELP_INVITE_QUESTION3", "HELP_INVITE_QUESTION4"};
    boolean title = verifyListTitleQuestion(titleQuestion, "HELP_MENU_INVITE_PROGRAM");
    String[] answers = {"HELP_INVITE_ANSWERS1", "HELP_INVITE_ANSWERS2", "HELP_INVITE_ANSWERS3", "HELP_INVITE_ANSWERS4"};
    boolean sAnswers = verifyListAnswersFAQ(answers, "HELP_MENU_INVITE_PROGRAM", HELP_MENU_INVITE_PROGRAM);
    return title && sAnswers;
  }

  public boolean verifyListGiftCardQuestion() {
    clickToElementByJavascript(driver, HELP_MENU_GIFT_CARD);
    wait100Time();
    String[] titleQuestion = {"HELP_GIFT_CARD_TITLE_QUESTION1", "HELP_COMMON_QUESTION10", "HELP_GIFT_CARD_TITLE_QUESTION2", "HELP_GIFT_CARD_TITLE_QUESTION3"};
    boolean title = verifyListTitleQuestion(titleQuestion, "HELP_GIFT_CARD_LINK");
    String[] answers = {"HELP_GIFT_CARD_ANSWERS1", "HELP_GIFT_CARD_ANSWERS2", "HELP_GIFT_CARD_ANSWERS3", "HELP_GIFT_CARD_ANSWERS4"};
    boolean sAnswers = verifyListAnswersFAQ(answers, "HELP_GIFT_CARD_LINK", HELP_MENU_GIFT_CARD);
    return title && sAnswers;
  }

  public boolean verifyListCreditQuestion() {
    clickToElementByJavascript(driver, HELP_MENU_TRAVEL_CREDIT);
    wait100Time();
    String[] titleQuestion = {"TRAVEL_CREDITS_FAQ2", "TRAVEL_CREDITS_FAQ3", "TRAVEL_CREDITS_FAQ1", "HELP_COMMON_QUESTION12", "HELP_CREDIT_QUESTION1"};
    boolean title = verifyListTitleQuestion(titleQuestion, "HELP_MENU_TRAVEL_CREDIT");
    String[] answers = {"HELP_CREDIT_ANSWERS1", "TRAVEL_CREDITS_FAQ1_ANSWERS", "TRAVEL_CREDITS_FAQ2_ANSWERS", "TRAVEL_CREDITS_FAQ3_ANSWERS", "HELP_CREDIT_ANSWERS4"};
    boolean sAnswers = verifyListAnswersFAQ(answers, "HELP_MENU_TRAVEL_CREDIT", HELP_MENU_TRAVEL_CREDIT);
    return title && sAnswers;
  }

  public boolean verifyListDiscountQuestion() {
    clickToElementByJavascript(driver, HELP_MENU_DISCOUNT);
    wait100Time();
    String[] titleQuestion = {"HELP_DISCOUNT_VOUCHER_QUESTION1", "HELP_DISCOUNT_VOUCHER_QUESTION2", "HELP_COMMON_QUESTION11",
      "HELP_COMMON_QUESTION14"};
    boolean title = verifyListTitleQuestion(titleQuestion, "HELP_MENU_DISCOUNT");
    String[] answers = {"HELP_DISCOUNT_VOUCHER_ANSWERS1", "HELP_DISCOUNT_VOUCHER_ANSWERS2", "HELP_DISCOUNT_VOUCHER_ANSWERS3", "HELP_COMMON_ANSWERS1",
      "HELP_COMMON_ANSWERS2", "HELP_COMMON_ANSWERS3"};
    boolean sAnswers = verifyListAnswersFAQ(answers, "HELP_MENU_DISCOUNT", HELP_MENU_DISCOUNT);
    return title && sAnswers;
  }

  public boolean verifyListPartialPayment() {
    clickToElementByJavascript(driver, HELP_MENU_PARTIAL_PAYMENT);
    wait100Time();
    String[] titleQuestion = {"HELP_COMMON_QUESTION14"};
    boolean title = verifyListTitleQuestion(titleQuestion, "HELP_MENU_PARTIAL_PAYMENT");
    String[] answers = {"HELP_PARTIAL_PAYMENT_ANSWERS"};
    boolean sAnswers = verifyListAnswersFAQ(answers, "HELP_MENU_PARTIAL_PAYMENT", HELP_MENU_PARTIAL_PAYMENT);
    return title && sAnswers;
  }

  public boolean verifyListRegistrationQuestion() {
    clickToElementByJavascript(driver, HELP_MENU_REGISTRATION);
    wait100Time();
    String[] titleQuestion = {"HELP_REGISTRATION_QUESTION1", "HELP_REGISTRATION_QUESTION2"};
    boolean title = verifyListTitleQuestion(titleQuestion, "HELP_MENU_REGISTRATION");
    String[] answers = {"HELP_REGISTRATION_ANSWERS1", "HELP_REGISTRATION_ANSWERS2"};
    boolean sAnswers = verifyListAnswersFAQ(answers, "HELP_MENU_REGISTRATION", HELP_MENU_REGISTRATION);
    return title && sAnswers;
  }

  public boolean verifyListSpecialRequestQuestion() {
    clickToElementByJavascript(driver, HELP_MENU_SPECIAL_REQUEST);
    wait100Time();
    String[] titleQuestion = {"HELP_SPECIAL_REQUEST_QUESTION2", "HELP_SPECIAL_REQUEST_QUESTION3", "HELP_COMMON_QUESTION7", "HELP_REGISTRATION_QUESTION1", "HELP_REGISTRATION_QUESTION2"};
    boolean title = verifyListTitleQuestion(titleQuestion, "HELP_MENU_SPECIAL_REQUEST");
    String[] answers = {"HELP_SPECIAL_REQUEST_ANSWERS2", "HELP_SPECIAL_REQUEST_ANSWERS1", "HELP_SPECIAL_REQUEST_ANSWERS3", "HELP_REGISTRATION_ANSWERS1"};
    boolean sAnswers = verifyListAnswersFAQ(answers, "HELP_MENU_SPECIAL_REQUEST", HELP_MENU_SPECIAL_REQUEST);
    return title && sAnswers;
  }

  public boolean verifyListContactQuestion() {
    clickToElementByJavascript(driver, HELP_MENU_CONTACT);
    wait200Time();
    String[] titleQuestion = {"HELP_CONTACT_QUESTION"};
    boolean title = verifyListTitleQuestion(titleQuestion, "HELP_MENU_CONTACT");
    String[] answers = {"HELP_CONTACT_ANSWERS1"};
    boolean sAnswers = verifyListAnswersFAQ(answers, "HELP_MENU_CONTACT", HELP_MENU_CONTACT);
    return title && sAnswers;
  }
}
