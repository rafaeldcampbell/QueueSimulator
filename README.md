# Simulador de filas

Este projeto foi desenvolvido em 2018-2, para a cadeira de Avaliação de Desempenho do bacharelado de Ciência da Computação na Universidade Federal Fluminense (UFF). O objetivo do projeto é simular alguma fila, considerando alguns parâmetros de entrada, e simular as entradas e atendimentos segundo variáveis aleatórias com distribuição exponencial.

### Funcionamento básico
Para este projeto, foi idealizado uma fila única que é atendida por vários funcionários; o primeiro elemento é criado no início da simulação e, os demais, assim que o anterior chega à fila. O tempo de chegada é definido pela fórmula <img src="https://render.githubusercontent.com/render/math?math=x = \frac{i}{\lambda}\log(u)">, onde <img src="https://render.githubusercontent.com/render/math?math=\lambda"> é a taxa de chegada definida e <img src="https://render.githubusercontent.com/render/math?math=u"> um valor aleatório, gerado por método congruente linear.

Uma vez que os elementos chegam à fila, são atendidos segundo a política definida (FIFO ou LIFO) e gera-se um tempo de atendimento, período onde o atendente estará ocupado. Esse tempo de atendimento é gerado da mesma forma que o tempo de chegada, mas usa-se a taxa de atendimento definida e outro valor aleatório. Finalizado o tempo, o elemento registra seu tempo de saída e o atendente recebe um novo elemento da fila.

### Como simular
Ao iniciar a execução do simulador, o usuário deve informar se deseja realizar um experimento pré-definido ou não. Caso opte por definir o próprio experimento, deve dar como entrada o tamanho da fila, tempo médio entre as chegadas (segundos), tempo médio de serviço (segundos), número de atendentes, política de atendimento e o tempo que será simulado (segundos).

Logo depois de conseguir as informações de entrada, o simulador imprime a saída para o usuário informando tanto os parâmetros de entrada quanto algumas métricas de interesse. Um _exemplo_ de execução da simulação é exibida a seguir.

~~~
 **** Experimento 1 ****
-- Entradas
Tamanho limite da fila: 20.0
Tempo de chegada: 0.02
Tempo de serviço: 0.03
Tipo de atendimento: FIFO
Tempo limite: 60.0
-- Medidas
Esperanca de W: 0.2606716497916042 //W é o tempo de espera
Esperanca de N: 21.183333333333334 //N é o número de elementos no sistema
Taxa de descarte: 10.4
Utilização: 0.9943249999991942
Utilização por fórmula: 0.75
~~~

Em seguida, o usuário deve informar se deseja imprimir o _backlog_ de eventos, que consiste em uma lista com o momento de entradas e saídas do sistema. Depois, o usuário pode optar por realizar um novo experimento, informando novas métricas de entrada.

Ao fim, caso tenha realizado mais de uma simulação, pode optar por gerar um gráfico que relaciona o **tempo de espera** com a **taxa de chegada**. Todos os gráficos são salvos na pasta **Gráfico**. _Vale ressaltar que o gráfico só faz sentido se mais de uma taxa de chegada for utilizada, pois, de outro modo, não terá dado a exibir_. Um exemplo de gráfico é exibido a seguir.
<p align="center">
  <img src="/Graficos/exemplo.png?raw=true"/>
</p>

### Como executar

Todas as classes e pacotes necessários estão disponíveis, na integra, em **src**. No mesmo diretório, dentro de **dist**, consta uma versão já construída em jar. Uma opção é abrir o projeto no [NetBeans](https://netbeans.org/) (IDE utilizada para desenvolver o projeto), construir e executar; alternativamente, pode-se executar o .jar por linha de comando. Para os usuários de Windows, está disponível um script (**execute.cmd**) que executa o .jar no prompt de comando.

### Mais detalhes
O relatório completo, entregue como parte da avaliação, está disponível na íntegra como **AD_Filas.pdf**. Neste documento consta toda a explicação dos blocos de código, bem como as fórmulas utilizadas e os parâmetros adotados com explicações mais detalhadas.

### Pacotes utilizados
Para a criação do gráfico, utiliza-se o pacote [JFreeChart](http://www.jfree.org/jfreechart/).
