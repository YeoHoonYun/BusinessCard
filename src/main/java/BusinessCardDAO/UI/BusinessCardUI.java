package BusinessCardDAO.UI;

import BusinessCardDAO.DAO.BusinessCardDAO;
import BusinessCardDAO.VO.BusinessCardDTO;
import BusinessCardDAO.VO.BusinessCardVO;
import org.apache.commons.collections4.ListUtils;

import java.io.IOException;
import java.util.List;
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
    int maxNum;

    public BusinessCardUI(String url) {
        scanner = new Scanner(System.in);
        businessCardDTO = new BusinessCardDTO();
        businessCardDAO = new BusinessCardDAO(businessCardDTO);
        this.url = ".\\BusinessCardDAO.json";
        maxNum = 5;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
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
        System.out.print("전체 조회 할까요?<Y/N> : ");
        String selectDataInput = scanner.next();
        List<BusinessCardVO> iterator = null;
        if (selectDataInput.equals("Y") || selectDataInput.equals("y")) {
            iterator =  businessCardDAO.selectCard();
        }
        else if(selectDataInput.equals("N") || selectDataInput.equals("n")) {
            System.out.print("조회할 이름을 검색하세요. : ");
            String selectMenu2 = scanner.next();
            iterator = businessCardDAO.selectCard(selectMenu2);
        }
        else{
            System.out.println("잘못된 입력값입니다. 메뉴로 이동합니다.");
            return;
        }

        System.out.println("--------------CardList----------------");
        // 전체 조회
//        int currentNum = 0;
//
//        for (Iterator<BusinessCardVO> it = iterator.iterator(); it.hasNext(); ) {
//            BusinessCardVO bc = it.next();
//            System.out.print((currentNum+1)+" | ID : " + bc.getCardNum() + " | ");
//            System.out.print("이름 : " + bc.getName() + " | ");
//            System.out.print("전화번호 : " + bc.getPhonNum() + " | ");
//            System.out.println("회사이름 : " + bc.getCompany());
//            currentNum++;
//        }
        // 페이지 조회
        List<List<BusinessCardVO>> listList = ListUtils.partition(iterator,this.maxNum);
        int page = 0;
        int currentNum = 0;
        while(true){
            if(page < 0 | page+1 > listList.size()) {
                System.out.println("페이지의 범위를 넘어갔습니다. 메뉴로 넘어갑니다.");
                break;
            }
            System.out.println("현재 페이지 : " + (page+1)+" / "+ listList.size() + " | 한 페이지 당 최대 출력 건수 : " + this.maxNum);
            for(BusinessCardVO bc : listList.get(page)){
                System.out.print(((currentNum++)+(page*5)+1)+" | ID : " + bc.getCardNum() + " | ");
                System.out.print("이름 : " + bc.getName() + " | ");
                System.out.print("전화번호 : " + bc.getPhonNum() + " | ");
                System.out.println("회사이름 : " + bc.getCompany());
            }
            System.out.print("(이전 페이지[Q]/다음페이지[W]/종료[그외 키]) : ");
            String key = scanner.next();
            if(key.equals("q") | key.equals("Q")){
                page--;
                continue;
            }
            else if(key.equals("w") | key.equals("W")){
                page++;
                continue;
            }
            else {
                System.out.println("잘못된 값이 입력되었습니다.");
            }
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
                     break;
                 } else {
                     System.out.println("잘못된 값을 입력하였습니다.");
                 }
             }while (true);
        }
    }
    public void deleteData(){
        System.out.println("-------------------------------------------------");
        System.out.println("* 삭제 후 제대로 종료 해주셔야 삭제가 되니 주의하세요.");
        System.out.println("삭제 방법");
        System.out.println("1. ID");
        System.out.println("2. 이름");
        System.out.println("--------------------------------------------------");
        System.out.print("삭제할 항목의 검색 값을 선택하세요. : ");
        String selectData = scanner.next();
        if(selectData.equals("1")) {
            System.out.print("삭제할 정보의 ID을 입력해주세요. : ");
            int selectNum = scanner.nextInt();
            businessCardDAO.deleteCard(selectNum);
            System.out.println("삭제 되었습니다.");
        }
        else if(selectData.equals("2")) {
            System.out.print("삭제할 정보의 이름을 입력해주세요. : ");
            String selectNum = scanner.next();
            businessCardDAO.deleteCard(selectNum);
            System.out.println("삭제 되었습니다.");
        }
        else{
            System.out.println("잘못된 값을 입력하였습니다. 메뉴로 넘어갑니다.");
        }
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
