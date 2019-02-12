import java.util.Scanner;

public class Main {

  // я так понимаю речь идет о частных сетях в классическом понимании, первые 2 октета всегда
  // 192.168. а оставшиеся 2 с диапазоном 0-254?

  // делал все в статике, ибо задание не требует иного

  static String[] firstIP;
  static String[] secondIP;
  static Scanner scanner = new Scanner(System.in);


  public static void main(String[] args) {

    int startIp;
    int endIP;

    System.out.println("введите первый IP-адрес: ");
    firstIP = inputIP();

    System.out.println("введите второй IP-адрес: ");
    secondIP = inputIP();

    if (Integer.parseInt(firstIP[2]) != Integer.parseInt(secondIP[2])){
      System.out.println("Невоозможно вывести диапазон, у IP-адресов разные подсети");
      return;
    }

    if (Integer.parseInt(firstIP[3]) < Integer.parseInt(secondIP[3])) {
      startIp = Integer.parseInt(firstIP[3]);
      endIP = Integer.parseInt(secondIP[3]);
    }
    else if (Integer.parseInt(firstIP[3]) > Integer.parseInt(secondIP[3])) {
      startIp = Integer.parseInt(secondIP[3]);
      endIP = Integer.parseInt(firstIP[3]);
    }
    else {
      System.out.println("В диапазоне 1 адрес: " + firstIP[0] + "." + firstIP[1] + "." + firstIP[2] + "." + firstIP[3]);
      return;
    }

    System.out.println("итоговый диапазон IP-адресов:");
    for (int i = startIp; i <= endIP ; i++) {
      System.out.println(firstIP[0] + "." + firstIP[1] + "." + firstIP[2] + "." + i);
    }

  }

  public static String[] inputIP() {
    String curIP  = null;
    boolean accept = false;
    while (!accept) {
      curIP = scanner.nextLine();
      String[] curIPArr = curIP.split("\\.");
      accept = validIP(curIPArr);
    }
    return curIP.split("\\.");
  }

  public static boolean validIP (String[] arr) {


    boolean valid = true;
    if (arr.length!=4) {
      System.out.println("IP-адрес введен неверно");
      valid = false;
    }
    if (arr[0].matches("[0-9]+") & arr[1].matches("[0-9]+") &arr[2].matches("[0-9]+") & arr[3].matches("[0-9]+")) {
      if (Integer.parseInt(arr[0]) != 192) {
        System.out.println("Введен неверный первый октет");
        valid = false;
      }

      if (Integer.parseInt(arr[1]) != 168) {
        System.out.println("Введен неверный второй октет");
        valid = false;
      }

      if (Integer.parseInt(arr[2]) <= 0 || Integer.parseInt(arr[2]) >= 254) {
        System.out.println("Введен неверный третий октет или его значения выходят за границу 0-254");
        valid = false;
      }

      if (Integer.parseInt(arr[3]) <= 0 || Integer.parseInt(arr[3]) >= 254) {
        System.out.println(
            "Введен неверный четвертый октет или его значения выходят за границу 0-254");
        valid = false;
      }
    }
    else  {
      System.out.println("В IP-адресе могут содержаться только положительные числа");
      valid= false;
    }

    return valid;
  }
}

