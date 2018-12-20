public class Main {

    private static DAO dao;

    public static void main(String[] args) {

        dao = new DAO();
        int k = 1;
        long tempo = System.currentTimeMillis();
        final int j = k;

        for (k = 1; k <= 100; k++) {
            final int i = k;
            final Entidade entidade = new Entidade();
            entidade.setId(k);
            entidade.setNome("NOME " + i);
            entidade.setDelete(false);
            entidade.setUpdate(false);

            //INSERINDO
            Runnable inserir = new Runnable() {
                public void run() {
                    System.out.println("Inserindo " + i);
                    dao.salvar(entidade);
                }
            };
            //inserir.run();

            //ATUALIZANDO
            Runnable atualizar = new Runnable() {
                public void run() {
                    System.out.println("Atualizando " + i);
                    entidade.setUpdate(true);
                    dao.atualizar(entidade);
                }
            };
            //atualizar.run();

            //DELETANDO
            Runnable deletar = new Runnable() {
                public void run() {
                    System.out.println("Deletando " + i);
                    entidade.setDelete(true);
                    dao.atualizar(entidade);
                }
            };
            //deletar.run();

            //THREAD
            Thread tInserir = new Thread(inserir);
            Thread tAtualizar = new Thread(atualizar);
            Thread tDeletar = new Thread(deletar);

            tInserir.start();
            tAtualizar.start();
            tDeletar.start();

        }
        tempo = System.currentTimeMillis() - tempo;
        System.out.println("Tempo: " + tempo);
    }
}
