import java.util.ArrayList;
import java.util.Scanner;

public class UserRepository {

    Scanner scanner = new Scanner(System.in);
    ArrayList<User> memberList = new ArrayList<User>();

    public UserRepository() {
        memberList.add(new User("superman", "1234", 20, "SuperMan"));
        memberList.add(new User("ironman", "1234", 32, "IronMan"));
        memberList.add(new User("hulk", "1234", 28, "Hulk"));
    }

    public void run() {
        System.out.println("Please Login");
        System.out.println("[1]로그인 [2]회원가입 [3]개인정보 수정 [4]회원탈퇴 [5]전체 회원 보기 [6]종료");

        switch (scanner.nextInt()) {
            case 1:
                login();
                break;
        }
    }

    private void login() {
        // 사용자로부터 입력받은 아이디, 비밀번호 가져오기
        System.out.println("아이디와 패스워드를 입력해주세요 Ex) test 1234");

        scanner.nextLine();
        String userInput = scanner.nextLine();

        String[] data = userInput.split(" ");

        for (User user: memberList) {
            if (user.matchId(data[0]) && user.matchPassword(data[1])) {
                System.out.println("로그인 성공");
            } else {
                System.out.println("아이디 혹은 비밀번호가 맞지않습니다.");
            }
            break;
        }
    }

    private void signUp() {

    }
}
