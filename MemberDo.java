import java.text.SimpleDateFormat;
import java.util.*;

//业务类
public class MemberDo {
    Scanner input = new Scanner(System.in);
    List<Member> memberList = new ArrayList<Member>();
    //开始菜单
    public void menu(){
        System.out.println("***************************欢迎进入超市会员管理系统*************************");
        System.out.println("1.积分累计   2.积分兑换    3.查询剩余积分    4.修改密码    5.开卡     6.退出");
        System.out.println("****************************************************************************");
        System.out.println("请选择：");
    }

    public void start(){
        boolean flag = true;
        do{
            menu();
            int choose = input.nextInt();
            switch(choose){
                case 1:
                    if(saveScore()){
                        System.out.println("积分累计成功！");
                    }else{
                        System.out.println("积分累计失败！");
                    }
                    break;
                case 2:
                    if(minusScore()){
                        System.out.println("积分兑换成功！");
                    }else{
                        System.out.println("积分兑换失败！");
                    }
                    break;
                case 3:
                    checkScore();
                    break;
                case 4:
                    modifyPassword();
                    break;
                case 5:
                    register();
                    break;
                case 6:
                    System.out.println("感谢您的使用，欢迎下次使用！");
                    flag = false;
                    break;
                default:
                    System.out.println("请重新输入");
                    break;
            }
        }while(flag);
    }

    //查询当前会员是否存在
    public Member hasMember(int id, String pwd){
        for(Member menmber:memberList){
            if(menmber.getCardId()==id && menmber.getPassword().equals(pwd)){
                return  menmber;
            }
        }
        return null;
    }
    //积分累计
    public boolean saveScore(){
        boolean flag = true;
        System.out.println("请输入会员号：");
        int id = input.nextInt();
        System.out.println("请输入密码：");
        String pwd = input.next();
        Member member = hasMember(id, pwd);
        if(member!=null){
            System.out.println("请输入您此次消费金额（1元积1分）");
            int score = input.nextInt();
            member.setScore(member.getScore()+score);
            flag = true;
        }else{
            System.out.println("不好意思，该会员卡不存在，无法积分");
            flag = false;
        }
        return flag;
    }

    //积分兑换
    public boolean minusScore(){
        boolean flag = true;
        System.out.println("请输入会员号：");
        int id = input.nextInt();
        System.out.println("请输入密码：");
        String pwd = input.next();
        Member member = hasMember(id, pwd);
        if(member!=null){
            System.out.println("请输入您要兑换的积分（100积分可抵0.1元）");
            int score = input.nextInt();
            if(score<member.getScore()) {
                member.setScore(member.getScore() - score);
                System.out.println("您已成功兑换"+score/100*0.1+"元");
                flag = true;
            }else{
                System.out.println("抱歉，积分不足，无法兑换！");
                flag = false;
            }
        }else{
            System.out.println("不好意思，该会员卡不存在，无法积分兑换");
            flag = false;
        }
        return flag;
    }

    public void checkScore(){
        System.out.println("请输入会员号：");
        int id = input.nextInt();
        System.out.println("请输入密码：");
        String pwd = input.next();
        Member member = hasMember(id, pwd);
        if(member!=null){
            System.out.println("会员卡号 姓名 剩余积分 开卡日期");
            System.out.println(member.getCardId()+"\t"+member.getName()+"\t"+member.getScore()+"\t"+member.getRegistDate());
        }else{
            System.out.println("不好意思，该会员卡不存在，无法查询积分");
        }
    }

    public void modifyPassword(){
        System.out.println("请输入会员号：");
        int id = input.nextInt();
        System.out.println("请输入旧密码：");
        String pwd = input.next();
        Member member = hasMember(id, pwd);
        while(member!=null){
            System.out.println("请输入新密码");
            String s1 = input.next();
            System.out.println("请再次输入新密码");
            String s2 = input.next();
            if(s1.equals(s2)&&s1.length()>6){
                member.setPassword(s1);
                System.out.println("密码修改成功");
                break;
            }else{
                System.out.println("两次密码输入不同或者长度小于6，请重新输入！");
            }
        }

    }
    public int createId(){
        Random random = new Random();
        int id = random.nextInt(99999999);
        for(Member member:memberList){
            if(member.getCardId()==id){
                id = random.nextInt(99999999);
            }
        }
        return id;
    }

    public void register(){
        Member member = new Member();
        System.out.println("请输入姓名：");
        member.setName(input.next());
        //随机生成卡号
        int cardId = createId();
        member.setCardId(cardId);

        System.out.println("请输入密码：");
        boolean flag = true;
        do{
            String pwd = input.next();
            if(pwd.length()<6){
                System.out.println("会员密码不得小于6位，请重新输入：");
                flag = false;
            }else{
                flag = true;
                member.setPassword(pwd);
            }
        }while(!flag);
        //每卡默认开卡赠送100积分
        member.setScore(100);

        Date date = new Date();
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sdate = formater.format(date);
        member.setRegistDate(sdate);

        System.out.println("恭喜，会员开通成功！系统赠送您100积分！您的会员卡号为"+cardId);
        memberList.add(member);
    }
}
