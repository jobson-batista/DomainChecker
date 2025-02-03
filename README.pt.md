# Domain Checker 🇧🇷

##@!#Descrição

O Domain Checker é uma aplicação Java que verifica a disponibilidade de domínios na internet. Atualmente, a aplicação busca por domínios .com e .com.br utilizando serviços como GoDaddy e Registro BR. Além disso, possui um Web Scraper que extrai informações de domínios a partir de uma página web e os armazena para consulta.

Tecnologias Utilizadas

Java 11+

JSoup (para web scraping)

Apache Log4j (para logging)

Java HttpClient (para requisições HTTP)

Dotenv (para gerenciar variáveis de ambiente)

## Como Funciona

WebScraper: Extrai possíveis domínios da página https://kworb.net/spotify/artists.html e salva em um arquivo artists.txt.

DomainCheckerService: Lê os domínios do arquivo e verifica a disponibilidade nos serviços GoDaddy e Registro BR.

O resultado dos domínios disponíveis é salvo em domains-available.txt.

Configuração e Execução

1. Configurar variáveis de ambiente

Crie um arquivo .env na raiz do projeto e adicione as credenciais da API do GoDaddy:

API_KEY=seu_api_key
SECRET_KEY=seu_secret_key

2. Compilar e Executar o Projeto

# Compilar o projeto (caso esteja usando Maven)
./gradlew clean shadowJar

# Executar Web Scraper
java -cp target/domain-checker.jar com.tecnologiadevalor.domainchecker.services.WebScraper

# Executar o Checker de Domínios
java -cp target/domain-checker.jar com.tecnologiadevalor.domainchecker.services.DomainCheckerService <caminho_do_arquivo>

Melhorias Futuras

Adicionar suporte a mais extensões de domínio

Melhorar performance da verificação

Criar uma interface gráfica para facilitar o uso

