public class BicicletaCarretera extends Bicicleta {
    
    private static int COUNT = 0;

    public BicicletaCarretera() {
        BicicletaCarretera.COUNT += 1;
        tipo = Tipo.CARRETERA;
        id = COUNT;
    }
    
    @Override
    public String toString() {
        return "Bicicleta de " + tipo + " " + id;
    }
}