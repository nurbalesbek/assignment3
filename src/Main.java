// Интерфейс сервера Германии
interface GermanyServer {
    void connectToGermanyServer();
}

// Интерфейс игры
interface Game {
    void play();
}

// Реализация игры Mortal Kombat
class MortalKombatGame implements Game {
    @Override
    public void play() {
        System.out.println("Fight!");
    }
}

// Адаптер для VPN
class VPNAdapter implements GermanyServer {
    private final Game game;

    public VPNAdapter(Game game) {
        this.game = game;
    }

    @Override
    public void connectToGermanyServer() {
        game.play();
        System.out.println("Соединение с сервером Германии через VPN");
    }
}

public class Main {
    public static void main(String[] args) {
        Game mortalKombat = new MortalKombatGame();
        GermanyServer adapter = new VPNAdapter(mortalKombat);

        adapter.connectToGermanyServer();
    }
}
