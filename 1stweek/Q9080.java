import java.util.Arrays;
import java.util.Scanner;

public class Q9080 {
    public static void main(String[] args) {
        System.out.println("테스트 케이스 수를 입력합니다.");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("시간 조건을 입력하세요");
            String T = scanner.nextLine();
            String[] result1 = T.split(":"); // result1 = 시와 분을 구분하는 것
            String[] result2 = result1[1].split(" "); // result2 = 시작한 시간과 사용기간을 구분해서 사용시간을 배열로 정리한 것
            if (Integer.parseInt(result1[0]) >= 22) {
                System.out.println(calculrate(Integer.parseInt(result2[1]),true));
            }
            else{
                System.out.println(calculrate(Integer.parseInt(result2[1]),false));
            }

        }

    }

    public static int calculrate(int soupureitaimu, boolean yokanyuumu) {

        int night_fee_apply = 0;
        if (yokanyuumu == true) {
            soupureitaimu -= 480;
            night_fee_apply += 5000;
            if (soupureitaimu > 0) {
                night_fee_apply += Math.ceil(soupureitaimu / 60) *1000;
            }
        }

       double normal_save = Math.ceil(soupureitaimu / 60) * 1000;

        if(night_fee_apply ==0 ){
            return (int) normal_save;
        }


        else{
            return normal_save < night_fee_apply ? night_fee_apply : (int) normal_save;
        }

    }


}
