import java.util.*;

public class Room {
    //1.创建 54张牌 定义集合容器
    private List<Card> allCards = new ArrayList<>();

    //2.初始化 54张牌 进去
    {
        //3.准备点数
        String[] sizes = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        //4.准备花色
        String[] colors = {"♠", "♥", "♣", "♦"};
        //5.组合点数和花色成为牌对象，加入到集合中去
        int num = 0;
        for (String size : sizes) {
            num++;
            for (String color : colors) {
                //6.创建牌对象
                Card card = new Card(size, color, num);
                //7.加入到集合中去
                allCards.add(card);
            }
        }
        //8.添加大小王
        Collections.addAll(allCards, new Card("小王", "🃏", ++num), new Card("大王", "👲", ++num));
        System.out.println("新牌是：" + allCards);
    }

    public void start() {
        //8.洗牌：打乱集合中的顺序
        Collections.shuffle(allCards);
        System.out.println("洗牌后：" + allCards);
        //9.发牌:定义三个玩家：玩家1，玩家2，玩家3
        Map<String, List<Card>> players = new HashMap<>();
        List<Card> player1 = new ArrayList<>();
        players.put("玩家1", player1);

        List<Card> player2 = new ArrayList<>();
        players.put("玩家2", player2);

        List<Card> player3 = new ArrayList<>();
        players.put("玩家3", player3);

        for (int i = 0; i < allCards.size() - 3; i++) {
            Card card = allCards.get(i);
            if (i % 3 == 0) {
                player1.add(card);
            } else if (i % 3 == 1) {
                player2.add(card);
            } else {
                player3.add(card);
            }
        }


        //10.拿三张底牌
        List<Card> lastCards = allCards.subList(allCards.size() - 3, allCards.size());
        System.out.println("底牌：" + lastCards);
        //抢地主：底牌集合直接倒给另一个玩家

        //11.对牌排序
        sortCards(player1);
        sortCards(player2);
        sortCards(player3);





    //12.看牌,遍历 Map 集合
    for(
    Map.Entry<String, List<Card>> entry:players.entrySet())

    {
        //获取到玩家名称
        String name = entry.getKey();
        //获取到玩家牌
        List<Card> cards = entry.getValue();
        //遍历玩家牌
        System.out.println(name + "的牌是：" + cards);
    }
}

    private void sortCards(List<Card> cards) {
        cards.sort(Comparator.comparingInt(Card::getNum));
    }
}
