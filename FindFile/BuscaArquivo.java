import java.io.File;

public class BuscaArquivo {

    public static void main(String[] args) {
        String caminhoInicial = "/Users/jhenriqueax/Downloads/src";
        String nomeArquivo = "arquivo.txt";
        
        String resultado = buscarArquivo(caminhoInicial, nomeArquivo);
        
        if (resultado != null) {
            System.out.println("Arquivo encontrado: " + resultado);
        } else {
            System.out.println("Arquivo não encontrado.");
        }
    }
    
    public static String buscarArquivo(String caminhoInicial, String nomeArquivo) {
        File raiz = new File(caminhoInicial);
        
        // Verifica se o caminho inicial é um arquivo e possui o nome buscado
        if (raiz.isFile() && raiz.getName().equals(nomeArquivo)) {
            return raiz.getAbsolutePath();
        }
        
        // Realiza a busca nos arquivos e subdiretórios a partir do caminho inicial
        String resultado = buscarArquivoRecursivo(raiz, nomeArquivo);
        
        // Caso o arquivo não seja encontrado
        return resultado;
    }
    
    private static String buscarArquivoRecursivo(File caminho, String nomeArquivo) {
        if (caminho.isDirectory()) {
            File[] arquivos = caminho.listFiles();
            
            if (arquivos != null) {
                for (File arquivo : arquivos) {
                    String resultado = buscarArquivoRecursivo(arquivo, nomeArquivo);
                    
                    if (resultado != null) {
                        return resultado;
                    }
                }
            }
        } else if (caminho.isFile() && caminho.getName().equals(nomeArquivo)) {
            return caminho.getAbsolutePath();
        }
        
        // Caso o arquivo não seja encontrado
        return null;
    }
    
   
}
