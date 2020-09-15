import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class UserRepository {

    Scanner scanner = new Scanner(System.in);
    ArrayList<User> memberList = new ArrayList<User>();

    int menuMode = 0;

    public UserRepository() {
        memberList.add(new User("superman", "1234", 20, "SuperMan"));
        memberList.add(new User("ironman", "1234", 32, "IronMan"));
        memberList.add(new User("hulk", "1234", 28, "Hulk"));
    }

    public void run() {

        System.out.println("학습용 회원정보 관리 프로그램");

        while (menuMode != 6) {

            System.out.println("[1]로그인 [2]회원가입 [3]개인정보 수정 [4]회원탈퇴 [5]전체 회원 보기 [6]종료");

            switch (scanner.nextInt()) {
                case 1:
                    menuMode = 1;
                    login();
                    break;
                case 2:
                    menuMode = 2;
                    signUp();
                    break;
                case 3:
                    menuMode = 3;
                    update();
                    break;
                case 4:
                    menuMode = 4;
                    delete();
                case 5:
                    menuMode = 5;
                    showAll();
                    break;
                case 6:
                    menuMode = 6;
                    break;
            }
        }
    }

    private void login() {
        // 사용자로부터 입력받은 아이디, 비밀번호 가져오기
        System.out.println("아이디와 패스워드를 입력해주세요 Ex) test 1234");

        String[] data = getStrings();

        // 회원정보 찾은 후 로그인
        User user = findId(data[0]);
        if (user == null) {
            System.out.println("아이디가 없습니다.");
        }

        if (user.matchPassword(data[1])) {
            System.out.println("로그인 성공");
        } else {
            System.out.println("비밀번호 오류입니다.");
        }
    }

    private String[] getStrings() {
        scanner.nextLine();
        String userInput = scanner.nextLine();

        return userInput.split(" ");
    }

    private void signUp() {
        System.out.println("회원가입을 위한 정보를 입력해주세요 Ex) test 1234 20 name");

        String[] data = getStrings();

        memberList.add(new User(data[0], data[1], Integer.parseInt(data[2]), data[3]));

    }

    private void showAll() {
        for (User user: memberList) {
            System.out.println(user);
        }
    }

    private void update() {
        System.out.println("업데이트할 아이디의 정보(비밀번호, 나이, 이름) 입력해주세요 Ex) test 1234 22 name2");

        String[] data = getStrings();

        User user = findId(data[0]);
        if (user != null) {
            user.update(data[1], Integer.parseInt(data[2]), data[3]);
        }
    }

    private void delete() {
        System.out.println("탈퇴할 아이디를 입력해주세요 Ex) test ");

        scanner.nextLine();
        String userId = scanner.nextLine();;

        for (User user: memberList) {
            if (user.matchId(userId)) {
                memberList.remove(user);
            }
        }
    }

    private User findId(String id) {
        for (User user: memberList) {
            if (user.matchId(id)) {
                return user;
            }
        }
        return null;
    }
}
