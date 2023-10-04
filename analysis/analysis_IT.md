<h2>INTRODUZIONE:</h2>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Il presente progetto ha l'obiettivo di condurre l'analisi, la progettazione e la prototipazione di un sistema informatico che consenta di gestire le vendite del settore chiosco/bar dell'azienda M.M., al fine di successiva implementazione e test.</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
La realizzazione dello stesso nasce come conseguenza di un problema rilevato dai responsabili dell'azienda, il quale sarà analizzato approfonditamente al fine di individuare la soluzione informatica più appropriata.</p>
<br>

<h2>SVILUPPO:</h2>

<h3>Contesto aziendale:</h3>
  <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    L'azienda M.M. è situata nella città di Santa Fe e si dedica principalmente al lavaggio di auto e altri tipi di veicoli, attività svolta con il nome commerciale di M.L.. Inoltre, dispone di un settore bar che opera come attività secondaria dell'azienda.</p>
	<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    I clienti del settore bar si dividono in due categorie: coloro che frequentano il bar principalmente per consumare cibo e/o bevande e coloro che entrano dal settore del lavaggio auto, in attesa del completamento del servizio. Il bar dispone di un'area con 18 tavoli per i clienti che desiderano consumare all'interno del locale, ma è anche possibile effettuare ordini da asporto. Accetta tre metodi di pagamento: contanti, bonifico bancario e pagamento tramite Mercado Pago.</p>
  <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    Il bar offre uno sconto speciale del 20% a tutti i dipendenti dell'azienda e a alcuni clienti abituali.</p>
	<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    Vengono consumati sia prodotti di terze parti (bibite, snack, prodotti da forno, ecc.) che prodotti di produzione interna (insalate, panini, frullati, ecc.). Il bar non dispone di un magazzino, quindi gli ordini ai fornitori vengono effettuati con una frequenza approssimativa settimanale secondo il principio Just-In-Time.</p>
	<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    Per quanto riguarda il personale, il bar dispone di due venditori/camerieri incaricati di prendere gli ordini, prepararli (nel caso di alimenti non elaborati) o inviarli in cucina (quando si tratta di piatti più complessi), portarli al tavolo e incassare dai clienti. Inoltre, c'è un responsabile generale incaricato di effettuare gli ordini di prodotti e materie prime dai fornitori e stabilire i prezzi del menu.</p>

<h3>Diagnosi del problema:</h3>

  <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    Dopo aver effettuato un rilevamento delle informazioni attraverso un programma di interviste e l'osservazione della metodologia di lavoro, ho identificato le seguenti problematiche:</p>
<ul>
  <li>Non viene mantenuto un registro, né fisico né digitale, dell'importo totale addebitato ai clienti né del metodo di pagamento utilizzato.</li>
  <li>Non viene registrato a quali vendite è stato applicato lo sconto del 20%.</li>
  <li>I prezzi dei prodotti sono elencati su liste stampate che spesso si perdono o danneggiano.</li>
  <li>Quando i prezzi aumentano, vengono stampate nuove liste di prodotti, ma spesso le liste con prezzi non aggiornati rimangono in circolazione.</li>
  <li>I venditori di solito non utilizzano queste liste perché le ritengono poco pratiche (a causa del gran numero di prodotti) e di solito memorizzano i prezzi dei prodotti più consumati. Questo rappresenta un problema considerando che i prezzi vengono aggiornati frequentemente a causa dell'inflazione.</li>
  <li>Non viene mantenuto un registro di ciò che viene consumato da ciascun tavolo al momento del pagamento dei clienti. I venditori solitamente memorizzano ciò che è stato consumato da ciascun cliente.</li>
</ul>
  <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    Tutto quanto sopra citato rendeva impossibile l'attività di contabilità alla fine della giornata e, ciò che è ancor più grave, alla fine del mese.</p>

<h3>Requisiti di sistema:</h3>

  <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  Con le informazioni raccolte sono stati stabiliti i seguenti requisiti funzionali e non funzionali:</p>
  <ul>
    <li><b>FUNZIONALI:</b>
      <ol>
        <li>Creare un nuovo prodotto, assegnandogli un codice, un nome, un prezzo e, se applicabile, un marchio e una categoria di prodotto.</li>
	<li>Filtrare i prodotti per codice, nome, marchio e/o categoria.</li>
	<li>Modificare qualsiasi campo di un prodotto.</li>
	<li>Eseguire la disattivazione logica di un prodotto.</li>
	<li>Creare un marchio assegnandogli un nome.</li>
	<li>Modificare un marchio.</li>
        <li>Eseguire la disattivazione logica di un marchio.</li>
        <li>Creare una nuova categoria di prodotto assegnandole un nome.</li>
        <li>Modificare una categoria di prodotto.</li>
        <li>Eseguire la disattivazione logica di una categoria di prodotto.</li>
        <li>Creare un nuovo tavolo assegnandogli un numero di tavolo.</li>
        <li>Modificare un tavolo.</li>
        <li>Eseguire la disattivazione logica di un tavolo.</li>
        <li>Creare un nuovo metodo di pagamento assegnandogli un nome.</li>
	<li>Modificare un metodo di pagamento.</li>
        <li>Eseguire la disattivazione logica di un metodo di pagamento.</li>
        <li>Aprire una nuova vendita registrando la data, l'ora e il numero di tavolo associato.</li>
        <li>Modificare una vendita attiva aggiungendo o rimuovendo prodotti. L'importo totale consumato deve essere calcolato automaticamente.</li>
        <li>Chiudere una vendita assegnandole un metodo di pagamento e visualizzando l'importo totale da addebitare al cliente.</li>
        <li>Visualizzare i guadagni ottenuti dalle vendite per una data o un intervallo di date.</li>
      </ol>
    </li>
    <br>
    <li><b>NON FUNZIONALI:</b>
      <ol>
        <li>Il sistema dovrà archiviare i dati in un database relazionale (SQL).</li>
        <li>Il sistema dovrà disporre di un processo di autenticazione che consenta di distinguere tra i ruoli di <i>utente</i> e <i>amministratore</i>.</li>
        <li>Le password degli <i>utenti</i> e degli <i>amministratori</i> dovranno essere crittografate nel database.</li>
        <li>Il sistema dovrà avere un'architettura MVC (modello-vista-controllore) sviluppata in linguaggio Java lato server (utilizzando Hibernate e JPA) e HTML, CSS e JavaScript lato client.</li>
      </ol>
    </li>
  </ul>
