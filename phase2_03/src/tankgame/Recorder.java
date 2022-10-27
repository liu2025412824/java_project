package tankgame;

import java.io.*;
import java.util.Vector;

/**
 * @author Lzy
 * @version 1.0
 */
public class Recorder {
    //定义变量，记录我方击毁敌人坦克数
    private static int allEnemyTankNum = 0;
    //定义IO对象,准备写数据到文件中
    private static BufferedWriter bw = null;
    private static BufferedReader br = null;
    //把记录文件保存到src下 ，这样文件可以跟着工程走
    //private static String recordFile = "e:\\javafiletest\\myrecord.txt";
    private static String recordFile = "src\\myrecord.txt";
    //定义Vector，指向MyPanel对象的敌人坦克Vector
    private static Vector<EnemyTank> enemyTanks = null;
    //定义一个Node的Vector，用于保存敌人信息的node
    private static Vector<Node> nodes = new Vector<>();

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks){
        Recorder.enemyTanks = enemyTanks;
    }

    //返回记录的文件目录
    public static String getRecordFile(){
        return recordFile;
    }

    //增加一个方法，用于读取reacordFile，恢复相关信息
    //该方法，在继续上局游戏的时候调用
    public static Vector<Node> getNodesAndEnemyTankRec(){
        try {
            br = new BufferedReader(new FileReader(recordFile));
            allEnemyTankNum = Integer.parseInt(br.readLine());
            //循环读取文件，生成nodes集合
            String line = "";
            while((line = br.readLine()) != null){
                String[] xyd = line.split(" ");
                Node node = new Node(Integer.parseInt(xyd[0]), Integer.parseInt(xyd[1]), Integer.parseInt(xyd[2]));
                nodes.add(node);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return nodes;
    }

    //增加一个方法，当游戏退出时，将allEnemyTankNum保存到recordFile
    //对keepRecord进行升级，保存敌人坦克的坐标和方向
    public static void keepRecord(){
        try {
            bw = new BufferedWriter(new FileWriter(recordFile));
            bw.write(allEnemyTankNum+"\r\n");
            //遍历敌人坦克的Vector，然后根据情况保存即可
            for(int i=0;i<enemyTanks.size();i++){
                EnemyTank enemyTank = enemyTanks.get(i);
                if(enemyTank.isLive){
                    String record = enemyTank.getX()+" "+enemyTank.getY()+" "+enemyTank.getDirect();
                    //写入到文件
                    bw.write(record+"\r\n");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static int getAllEnemyTankNUm() {
        return allEnemyTankNum;
    }
    public static void setAllEnemyTank(int allEnemyTankNum) {
        Recorder.allEnemyTankNum = allEnemyTankNum;
    }

    public static void addAllEnemyTankNum(){
        Recorder.allEnemyTankNum++;
    }
}
