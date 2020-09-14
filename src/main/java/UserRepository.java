import java.util.ArrayList;
import java.util.Scanner;

public class UserRepository {

    Scanner scanner = new Scanner(System.in);
    ArrayList<User> memberList = new ArrayList<User>();

    int num = 0;

    public UserRepository() {
        memberList.add(new User("superman", "1234", 20, "SuperMan"));
        memberList.add(new User("ironman", "1234", 32, "IronMan"));
        memberList.add(new User("hulk", "1234", 28, "Hulk"));
    }

    public void run() {

        System.out.println("학습용 회원정보 관리 프로그램");

        while (getNum() != 6) {

            System.out.println("[1]로그인 [2]회원가입 [3]개인정보 수정 [4]회원탈퇴 [5]전체 회원 보기 [6]종료");

            switch (scanner.nextInt()) {
                case 1:
                    login();
                    setNum(1);
                    break;
                case 2:
                    signUp();
                    setNum(2);
                    break;
                case 3:
                    update();
                    setNum(3);
                    break;
                case 4:
                    delete();
                    setNum(4);
                case 5:
                    showAll();
                    setNum(5);
                    break;
                case 6:
                    setNum(6);
                    break;
            }
        }
    }

    private void login() {
        // 사용자로부터 입력받은 아이디, 비밀번호 가져오기
        System.out.println("아이디와 패스워드를 입력해주세요 Ex) test 1234");

        scanner.nextLine();
        String userInput = scanner.nextLine();

        String[] data = userInput.split(" ");

        // get 방식보단 객체에 메시지를 보낸다
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
        System.out.println("회원가입을 위한 정보를 입력해주세요 Ex) test 1234 20 name");

        scanner.nextLine();
        String newUserData = scanner.nextLine();

        String[] data = newUserData.split(" ");

        memberList.add(new User(data[0], data[1], Integer.parseInt(data[2]), data[3]));

    }

    private void showAll() {
        for (User user: memberList) {
            System.out.println(user);
        }
    }

    private void update() {
        System.out.println("업데이트할 아이디의 정보(비밀번호, 나이, 이름) 입력해주세요 Ex) 1234 22 name2");

        scanner.nextLine();
        String updateUserData = scanner.nextLine();;

        String[] data = updateUserData.split(" ");

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

    private void setNum(int num) {
        this.num = num;
    }

    private int getNum() {
        return num;
    }

}
