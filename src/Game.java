public class Game {
    public static void main(String[] args) {
        //开发斗地主游戏
        //1.每个牌都是一个对象，定义牌类
        //2.游戏房间也是一个对象，定义房间类，54张，启动游戏
        Room room = new Room();
        room.start();
    }
}
