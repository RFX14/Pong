public class Main {
    static int xSize = 640;
    static int ySize = 480;
    public static void main(String[] args) {
        boolean run = true;
        Thread t1 = new Thread(new Menu());
        
        t1.start();

        while(run) {
            if(Menu.getNext().equalsIgnoreCase("game")) {
                run = false;
                Thread t2 = new Thread(new Game());
                Menu.frame.dispose();
                t2.start();
            } else if(Menu.getNext().equalsIgnoreCase("settings")) {
                run = false;
                Thread t3 = new Thread(new Settings());
                Menu.frame.dispose();
                t3.start();
            }
        }
    }

    public static int getXFrame() {
        return xSize;
    }

    public static int getYFrame() {
        return ySize;
    }
}