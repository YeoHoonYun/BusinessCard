package BusinessCardDAO.UI;

import BusinessCardDAO.DAO.BusinessCardDAO;
import BusinessCardDAO.VO.BusinessCardDTO;
import BusinessCardDAO.VO.BusinessCardVO;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by cjswo9207u@gmail.com on 2018-12-17
 * Github : https://github.com/YeoHoonYun
 */
public class BusinessCardUI {
    Scanner scanner;
    BusinessCardDTO businessCardDTO;
    BusinessCardDAO businessCardDAO;
    String url;

    public BusinessCardUI(String url) {
        scanner = new Scanner(System.in);
        businessCardDTO = new BusinessCardDTO();
        businessCardDAO = new BusinessCardDAO(businessCardDTO);
        this.url = ".\\BusinessCardDAO.json";
    }

    public void selectMenu() throws IOException {
        businessCardDAO.readFile(url);
        while (true) {
            System.out.println("-----------MENU----------");
            System.out.println("1. 데이터 조회");
            System.out.println("2. 데이터 삽입");
            System.out.println("3. 데이터 삭제");
            System.out.println("4. 데이터 수정");
            System.out.println("Q. 종료(자동으로 파일 저장)");
            System.out.println("-------------------------");
            System.out.print("선택하세요. : ");
            String selectMenu = scanner.next();
            if(selectMenu.equals("1")){
                this.selectData();
            }
            else if(selectMenu.equals("2")){
                this.insertData();
            }
            else if(selectMenu.equals("3")){
                this.deleteData();
            }
            else if(selectMenu.equals("4")){
                this.modyfiData();
            }else if(selectMenu.equals("Q") | selectMenu.equals("q")){
                System.out.println("종료합니다. 입력된 값은 저장됩니다.");
                this.storeData();
                break;
            }
            else{
                System.out.println("다시 입력하세요.");
                continue;
            }

        }
    }
    public void selectData(){
        Iterator<BusinessCardVO> iterator =  businessCardDAO.selectCard();
        System.out.println("--------------CardList----------------");
        for (Iterator<BusinessCardVO> it = iterator; it.hasNext(); ) {
            BusinessCardVO bc = it.next();
            System.out.print("ID : " + bc.getCardNum() + " | ");
            System.out.print("이름 : " + bc.getName() + " | ");
            System.out.print("전화번호 : " + bc.getPhonNum() + " | ");
            System.out.println("회사이름 : " + bc.getCompany());
        }
        System.out.println("-------------------------------------");
    }
    public void insertData(){
        boolean bo = true;
        while (bo) {
            System.out.print("이름을 입력하세요. : ");
            String insertName = scanner.next();
            System.out.print("전화번호를 입력하세요. : ");
            String insertNum = scanner.next();
            System.out.print("회사를 입력하세요. : ");
            String insertCom = scanner.next();
            businessCardDAO.addCard(insertName,insertNum,insertCom);
             do {
                 System.out.print("더 입력 하시겠습니까?(Y/N)");
                 String insertbo = scanner.next();
                 if (insertbo.equals("N") | insertbo.equals("n")) {
                     System.out.println("입력을 종료합니다.");
                     bo = false;
                     break;
                 } else if (insertbo.equals("Y") | insertbo.equals("Y")) {
                     continue;
                 } else {
                     System.out.println("잘못된 값을 입력하였습니다.");
                     break;
                 }
             }while (true);
        }
    }
    public void deleteData(){
        System.out.print("삭제할 정보의 ID을 입력해주세요. : ");
        int selectNum = scanner.nextInt();
        businessCardDAO.deleteCard(selectNum);
        System.out.println("삭제 되었습니다.");
    }
    public void modyfiData(){
        System.out.print("수정할 ID를 입력하세요. : ");
        int selectNum = scanner.nextInt();
        System.out.println("-------------------------");
        System.out.println("1. 이름");
        System.out.println("2. 전화번호");
        System.out.println("3. 회사");
        System.out.println("-------------------------");
        System.out.print("수정할 항목을 선택하세요. : ");
        String mody = scanner.next();
        if(mody.equals("1")) {
            System.out.print("수정할 내용을 입력하세요. : ");
            String modyData = scanner.next();
            businessCardDAO.modifyName(selectNum, modyData);
        }
        else if(mody.equals("2")) {
            System.out.print("수정할 내용을 입력하세요. : ");
            String modyData = scanner.next();
            businessCardDAO.modifyPhonNum(selectNum, modyData);
        }
        else if(mody.equals("3")) {
            System.out.print("수정할 내용을 입력하세요. : ");
            String modyData = scanner.next();
            businessCardDAO.modifyCompany(selectNum, modyData);
        }
        else{
            System.out.println("잘못된 데이터를 입력하였으므로 메뉴로 이동합니다.");
        }
    }
    public void storeData() throws IOException {
        businessCardDAO.writeFile(url);
    }
}
