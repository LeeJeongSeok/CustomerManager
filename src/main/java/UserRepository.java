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
        menu();
        setMenu(scanner.nextInt());
    }

    private void menu() {
        System.out.println("Please Login");
        System.out.println("[1]로그인 [2]회원가입 [3]개인정보 수정 [4]회원탈퇴 [5]전체 회원 보기 [6]종료");
    }

    private void setMenu(int number) {
        switch (number) {
            case 1:
                login();
                break;
        }
    }

    private void login() {
        // 사용자로부터 입력받은 아이디, 비밀번호 가져오기
        scanner.nextLine();
        String login = scanner.nextLine();

        String[] user= login.split(" ");

        for (int i = 0; i < memberList.size(); i++) {
            if (user[0].equals(memberList.get(i).getId()) == user[1].equals(memberList.get(i).getPassword())) {
                System.out.println("로그인 성공");
            } else {
                System.out.println("아이디 혹은 비밀번호가 맞지않습니다.");
            }
            break;
        }
        // ArrayList<User>에 있는 아이디와 비밀번호 비교
    }
}
