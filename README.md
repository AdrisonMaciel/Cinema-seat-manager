# 🎬 Sistema de Gerenciamento de Assentos de Cinema

Este projeto foi desenvolvido em **Java** com o objetivo de simular a gestão de assentos em uma sala de cinema.  
Ele permite que o usuário cadastre valores de ingressos, visualize o mapa da sala, reserve assentos, cancele reservas e acompanhe o total arrecadado.  

## 🚀 Funcionalidades

- Cadastro de valores para ingressos **Normais** e **VIPs**  
- Reserva de assentos (com opção de **inteira** ou **meia-entrada**)  
- Cancelamento de reservas  
- Exibição do **mapa da sala** com assentos livres (`O`) e ocupados (`X`)  
- Exibição do total de assentos e da **arrecadação** atual  

## 🛠️ Tecnologias Utilizadas

- Java (JDK 8+)
- Terminal/console
- Serialização de objetos  
- Scanner para entrada de dados via terminal  

## 📌 Estrutura da Sala

- 5 linhas e 10 colunas (50 assentos no total)  
- Linhas **0 e 1** → Setor VIP  
- Linhas **2, 3 e 4** → Setor Normal  

## 💡 Exemplos

### 📍 Mapa de Assentos (O = livre, X = ocupado)

```text
O O O O X X O O O X  
X O O O X O O O O O  
O X O O O X X X X O  
O O X O O O O X O O  
O O X X X O O O O O  
```
