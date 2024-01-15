import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

	public void run() {
		System.out.println("==명언 앱 실행==");
		Scanner sc = new Scanner(System.in);

		List<WiseSaying> wisesayings = new ArrayList<>();

		int lastArticleId = 0;

		String content = null;
		String author = null;

		while (true) {
			System.out.print("명령어 ) ");
			String cmd = sc.nextLine();

			if (cmd.equals("등록")) {
				int id = lastArticleId + 1;
				String regDate = Util.regDate();

				System.out.print("명언 : ");
				content = sc.nextLine();
				System.out.print("작가 : ");
				author = sc.nextLine();

				WiseSaying wisesaying = new WiseSaying(id, regDate, content, author);
				wisesayings.add(wisesaying);

				System.out.printf("%d번 명언이 등록되었습니다.\n", id);
				lastArticleId++;

			} else if (cmd.equals("목록")) {

//				if (wisesayings.size() == 0) {
//					System.out.println("등록 된 명언이 없습니다.");
//					continue;
//				}
				System.out.println("번호   /   작가   /   명언");
				System.out.println("===========================");

				for (int i = wisesayings.size() - 1; i >= 0; i--) {
					WiseSaying ws = wisesayings.get(i);

					System.out.printf("%d   /   %s   /   %s\n", ws.getId(), ws.getAuthor(), ws.getContent());
				}

			} else if (cmd.startsWith("삭제?id=")) {

				String[] cmdDiv = cmd.split("=");

				int id = 0;

				try {
					id = Integer.parseInt(cmdDiv[1]);
				} catch (Exception e) {
					System.out.println("번호는 정수로 입력해주세요");
					continue;
				}

				WiseSaying foundWisesaying = null;

				for (int i = 0; i < wisesayings.size(); i++) {
					WiseSaying ws = wisesayings.get(i);
					if (ws.getId() == id) {
						foundWisesaying = ws;
						break;
					}
				}

				if (foundWisesaying == null) {
					System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
					continue;
				}
				wisesayings.remove(foundWisesaying);
				System.out.println(id + "번 명언이 삭제되었습니다.");

			} else if (cmd.startsWith("수정?id=")) {

				String[] cmdDiv = cmd.split("=");

				int id = 0;

				try {
					id = Integer.parseInt(cmdDiv[1]);
				} catch (Exception e) {
					System.out.println("번호는 정수로 입력해주세요");
					continue;
				}

				WiseSaying foundWisesaying = null;

				for (int i = 0; i < wisesayings.size(); i++) {
					WiseSaying ws = wisesayings.get(i);
					if (ws.getId() == id) {
						foundWisesaying = ws;
						break;
					}
				}

				if (foundWisesaying == null) {
					System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
					continue;
				}

				System.out.printf("명언(기존) : %s\n", foundWisesaying.getContent());
				System.out.printf("작가(기존) : %s\n", foundWisesaying.getAuthor());

				System.out.print("명언 : ");
				String newContent = sc.nextLine();
				System.out.print("작가 : ");
				String newAuthor = sc.nextLine();

				foundWisesaying.setContent(newContent);
				foundWisesaying.setAuthor(newAuthor);

				System.out.println(id + "번 명언이 수정되었습니다.");

			}  else if(cmd.startsWith("상세보기?id=")){
				String[] cmdDiv = cmd.split("=");

				int id = 0;

				try {
					id = Integer.parseInt(cmdDiv[1]);
				} catch (Exception e) {
					System.out.println("번호는 정수로 입력해주세요");
					continue;
				}

				WiseSaying foundWisesaying = null;

				for (int i = 0; i < wisesayings.size(); i++) {
					WiseSaying ws = wisesayings.get(i);
					if (ws.getId() == id) {
						foundWisesaying = ws;
						break;
					}
				}

				if (foundWisesaying == null) {
					System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
					continue;
				}
				
				System.out.printf("번호 : %d\n", foundWisesaying.getId());
				System.out.printf("날짜 : %s\n", foundWisesaying.getRegDate());
				System.out.printf("작가 : %s\n", foundWisesaying.getAuthor());
				System.out.printf("내용 : %s\n", foundWisesaying.getContent());

		
	}else {
				System.out.println("명령어를 다시 입력해주세요.");
			}

		}

	}

}
