/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.develop.votogen.game;


import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author motoka
 */
@Service
public class Cards {

    private List<Card> deck1 = new LinkedList<Card>();
    private List<Card> deck2 = new LinkedList<Card>();
    private List<Card> deck3 = new LinkedList<Card>();
    private List<Card> deck4 = new LinkedList<Card>();
    private List<Card> deck5 = new LinkedList<Card>();
    private List<Card> deck6 = new LinkedList<Card>();
    private List<Card> deck7 = new LinkedList<Card>();
    private List<Card> deck8 = new LinkedList<Card>();

    public Cards() {
        //deck1
        this.deck1.add(new Card(1, "Para que eu me desapegue, "));
        this.deck1.add(new Card(2, "Se é meu desejo recomeçar outra vez, "));
        this.deck1.add(new Card(3, "Para que eu acredite em mim mesmo, "));
        this.deck1.add(new Card(4, "Se a ilusão me parece real, "));
        this.deck1.add(new Card(5, "Para estar satisfeito de prazer, "));
        this.deck1.add(new Card(6, "Se acho que sei tudo, "));
        this.deck1.add(new Card(7, "Para controlar minha ansiedade, "));
        this.deck1.add(new Card(8, "Para encontrar o que estou procurando, "));
        this.deck1.add(new Card(9, "Para controlar minha raiva, "));
        //deck2
        this.deck2.add(new Card(1, "preciso me soltar mais. "));
        this.deck2.add(new Card(2, "é bom aceitar a misericórdia divina, o perdão. "));
        this.deck2.add(new Card(3, "preciso ter mais bom humor, mais prazer e alegria. "));
        this.deck2.add(new Card(4, "devo prestar mais atenção em mim. "));
        this.deck2.add(new Card(5, "devo aquietar meus pensamentos. "));
        this.deck2.add(new Card(6, "devo parar de fantasiar. "));
        this.deck2.add(new Card(7, "necessito aceitar da existência o que ela me dá, e devolver quando ela me pede. "));
        this.deck2.add(new Card(8, "ver tudo com mais profundidade. "));
        this.deck2.add(new Card(9, "preciso me purificar. "));
        //deck3
        this.deck3.add(new Card(1, "Assim, a aceitação de meu próprio viver me permite sentir "));
        this.deck3.add(new Card(2, "Assim, posso receber ajuda espiritual e "));
        this.deck3.add(new Card(3, "Assim, esse sacrifício me trará "));
        this.deck3.add(new Card(4, "Desta maneira, o controle das emoções me permite sentir "));
        this.deck3.add(new Card(5, "Assim, minha ajuda ao outro me traz "));
        this.deck3.add(new Card(6, "A fim de que a difícil relação com o outro me permita sentir "));
        this.deck3.add(new Card(7, "A fim de que a boa relação com o outro me permita sentir "));
        this.deck3.add(new Card(8, "A fim de receber o que mereço: "));
        this.deck3.add(new Card(9, "Assim, este caminho luminoso me trará "));
        //deck4
        this.deck4.add(new Card(1, " a Consciência do Silêncio, "));
        this.deck4.add(new Card(2, " o Amor, "));
        this.deck4.add(new Card(3, " a Cura, "));
        this.deck4.add(new Card(4, " a Fé em Mim Mesmo, "));
        this.deck4.add(new Card(5, "a Sabedoria Divina, "));
        this.deck4.add(new Card(6, " a Boa Sorte, "));
        this.deck4.add(new Card(7, " a Proteção Divina, "));
        this.deck4.add(new Card(8, " a Conexão com o Divino, "));
        this.deck4.add(new Card(9, " a Consciência dos Acontecimentos, "));
        //deck5
        this.deck5.add(new Card(1, "que me faz aceitar essa situação, "));
        this.deck5.add(new Card(2, "que me faz agir corretamente e, "));
        this.deck5.add(new Card(3, "que me faz silenciar, "));
        this.deck5.add(new Card(4, "que me faz recomeçar, "));
        this.deck5.add(new Card(5, "que me faz respirar, "));
        this.deck5.add(new Card(6, "que me faz compreender, "));
        this.deck5.add(new Card(7, "que aquieta meu coração, "));
        this.deck5.add(new Card(8, "que me faz agir, "));
        this.deck5.add(new Card(9, "que me faz conviver com os outros, "));
        //deck6
        this.deck6.add(new Card(1, "com respeito. "));
        this.deck6.add(new Card(2, "com naturalidade. "));
        this.deck6.add(new Card(3, "com liberdade. "));
        this.deck6.add(new Card(4, "com transcendência. "));
        this.deck6.add(new Card(5, "com sutileza. "));
        this.deck6.add(new Card(6, "com vontade. "));
        this.deck6.add(new Card(7, "com devoção. "));
        this.deck6.add(new Card(8, "com disciplina. "));
        this.deck6.add(new Card(9, "com firmeza. "));
        //deck7
        this.deck7.add(new Card(1, "Para receber a energia de criatividade da criação; "));
        this.deck7.add(new Card(2, "Para sentir a presença divina em mim; "));
        this.deck7.add(new Card(3, "Para receber esta mensagem sincronizada; "));
        this.deck7.add(new Card(4, "Para controlar a minha mente; "));
        this.deck7.add(new Card(5, "Para estar aqui e agora, atento; "));
        this.deck7.add(new Card(6, "Para receber a irradiação dinâmica de viver intensamente; "));
        this.deck7.add(new Card(7, "Para não esquecer que Eu Sou Sagrado; "));
        this.deck7.add(new Card(8, "Para receber a abundância e bem aventurança na Terra; "));
        this.deck7.add(new Card(9, "Para dominar a minha ira; "));
        //deck8
        this.deck8.add(new Card(1, "afinal de contas, a resposta é Sim! É sempre Sim!"));
        this.deck8.add(new Card(2, "afinal de contas, Eu Sou o que quero ser. Eu Sou único em todo o Universo."));
        this.deck8.add(new Card(3, "afinal de contas, todas as bênçãos dos céus estão disponíveis. "));
        this.deck8.add(new Card(4, "afinal de contas, tudo é tudo que há e isto também passará."));
        this.deck8.add(new Card(5, "afinal de contas, tudo o que está acontecendo é fruto do que eu mesmo plantei!"));
        this.deck8.add(new Card(6, "afinal de contas, para que dê certo é preciso fé."));
        this.deck8.add(new Card(7, "afinal de contas, passado e futuro só existem na mente. A verdade é o aqui e agora, o Presente."));
        this.deck8.add(new Card(8, "afinal de contas, todos nascem, vivem e morrem sós, mesmo que bem acompanhados. Aprender a viver comigo mesmo é o grande aprendizado."));
        this.deck8.add(new Card(9, "afinal de contas, a ansiedade sob controle se transforma em criatividade."));

    }

    public Card findInDeck(int deckNumber, int id) {
        List<Card> deck = null;
        switch (deckNumber) {
            case 1:
                deck = this.deck1;
                break;
            case 2:
                deck = this.deck2;
                break;
            case 3:
                deck = this.deck3;
                break;
            case 4:
                deck = this.deck4;
                break;
            case 5:
                deck = this.deck5;
                break;
            case 6:
                deck = this.deck6;
                break;
            case 7:
                deck = this.deck7;
                break;
            case 8:
                deck = this.deck8;
                break;
        }

        for (Card card : deck) {
            if (card.getId() == id) return card;
        }
        return null;
    }


    public List<String> selectCards (CardsRequest cards){

        List<String> msgList = new LinkedList<>();
        int deckNumber = 1;
        //procurando as cartas no baralho
        for (Integer l : cards.getCards()) {
            //verificando se as cartas estao dentro do deck
            if (l > 9 || l < 1) {
                throw new ArrayIndexOutOfBoundsException("card is not in the deck");
            } else {
                Card c = findInDeck(deckNumber, l);
                msgList.add(c.getMessage());
                deckNumber++;
            }
        }
        return msgList;
    }


    public String completeMessage (List<String> msgList){

        StringBuilder completeMessage = new StringBuilder();
        for (String aMsgList : msgList) {
            completeMessage.append(aMsgList.trim()).append(" ");
        }
        return completeMessage.toString();
    }
}