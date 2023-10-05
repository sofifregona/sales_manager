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
<h3>Classi coinvolte:</h3>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    Di seguito vengono descritte le classi coinvolte nello sviluppo del sistema, con i relativi attributi.</p>
<ul>
    <li>Marca: id, nome e attivo.</li>
    <li>Categoria: id, nome e attivo.</li>
    <li>Prodotto: id, codice, nome, prezzo, marca, categoria e attivo.</li>
    <li>Tavolo: id, numero e attivo.</li>
    <li>Metodo di pagamento: id, nome e attivo.</li>
    <li>Vendita: id, data e ora, tavolo, stato, prodotti e totale.</li>
</ul>

<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    I campi con il nome <i>attivo</i> sono quelli che consentiranno l'attivazione e la disattivazione logica degli elementi assegnando loro un valore booleano: <i>true</i> se è attivo, <i>false</i> se è stato disattivato.</p>

<h3>Diagramma Entità-Relazione e Schema Relazionale del Database:</h3>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    Viene sviluppato il modello logico del database attraverso un diagramma ER e, a partire da questo, lo schema relazionale del database.</p>

<p align="center"><img src="https://github.com/sofifregona/sales_manager/blob/master/analysis/img/ER-diagram.jpg" alt="Diagramma ER" width="600" /></p>
<p align="center"><img src="https://github.com/sofifregona/sales_manager/blob/master/analysis/img/relational-schema.jpg" alt="Schema Relazionale" width="600" /></p>

<h3>Soggetti del sistema:</h3>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <b>Amministratore:</b> Il responsabile del settore delle vendite o la persona designata da quest'ultimo.</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <b>Utente:</b> Gli impiegati che effettuano le vendite e forniscono il servizio ai clienti.</p>

<h3>Casi d'Uso:</h3>

<table align="center">
    <tr><td width="600" align="center">
        <b>Caso d'Uso:</b> CreateBrand
    </td></tr>
    <tr><td width="600">
        <b>ID:</b> 1
    </td></tr>
    <tr><td width="600">
        <b>Descrizione:</b> L'amministratore desidera creare un nuovo marchio.
    </td></tr>
    <tr><td width="600">
        <b>Attori Principali:</b> Amministratore.
    </td></tr>
    <tr><td width="600">
        <b>Attori Secondari:</b> Nessuno.
    </td></tr>
    <tr><td width="600">
        <b>Precondizioni:</b> Nessuna.
    </td></tr>
    <tr><td width="600">
        <b>Flusso Principale:</b>
            <ol>
                <li>Nella sezione <i>registra marchio</i> si inserisce il nome del marchio.</li>
                <li>Si seleziona <i>salva</i>.</li>
                <li>Vengono convalidati i dati.</li>
            </ol>
    </td></tr>
    <tr><td width="600">
        <b>Postcondizioni:</b> 
            <ol>
                <li>Viene creato un nuovo marchio.</li>
            </ol>
    </td></tr>
    <tr><td width="600">
        <b>Flussi Alternativi:</b>
            <ol>
                <li>InactiveElement
                    <ol>
                        <li>Il marchio esiste nel database ma era stato disattivato in precedenza. Viene riattivato modificando il suo stato <i>attivo</i> a <i>true</i>.</li>
                    </ol>
                </li>
                <li>InvalidElement
                    <ol>
                        <li>Il marchio esiste nel database ed è attivo. Viene segnalato che esiste già un marchio con lo stesso nome e si richiede di inserire un nome valido.</li>
                    </ol>
                </li>
                <li>EmptyName
                    <ol>
                        <li>Si segnala che il campo <i>nome</i> non può essere vuoto e si richiede di inserire un nome valido.</li>
                    </ol>
                </li>
                <li>Cancel</li>
            </ol>
    </td></tr>
</table>

<table align="center">
    <tr><td width="600" align="center">
        <b>Caso d'Uso:</b> UpdateBrand
    </td></tr>
    <tr><td width="600">
        <b>ID:</b> 2
    </td></tr>
    <tr><td width="600">
        <b>Descrizione:</b> L'amministratore desidera modificare un marchio esistente.
    </td></tr>
    <tr><td width="600">
        <b>Attori Principali:</b> Amministratore.
    </td></tr>
    <tr><td width="600">
        <b>Attori Secondari:</b> Nessuno.
    </td></tr>
    <tr><td width="600">
        <b>Precondizioni:</b>
        <ol>
            <li>Il marchio deve esistere.</li>
        </ol>
    </td></tr>
    <tr><td width="600">
        <b>Flusso Principale:</b>
        <ol>
            <li>Si seleziona <i>modifica</i> per il marchio da modificare.</li>
            <li>Nella sezione <i>modifica marchio</i> si inserisce il nuovo nome.</li>
            <li>Si seleziona <i>salva</i>.</li>
            <li>Vengono convalidati i dati.</li>
        </ol>
    </td></tr>
    <tr><td width="600">
        <b>Postcondizioni:</b>
        <ol>
            <li>Il marchio selezionato viene modificato.</li>
        </ol>
    </td></tr>
    <tr><td width="600">
        <b>Flussi Alternativi:</b>
        <ol>
            <li>InactiveElement
                <ol>
                    <li>Il marchio esiste nel database ma era stato disattivato in precedenza. Viene riattivato modificando il suo stato <i>attivo</i> a <i>true</i> e il marchio attuale viene disattivato logicamente.</li>
                </ol>
            </li>
            <li>InvalidElement
                <ol>
                    <li>Il marchio esiste nel database ed è attivo. Viene segnalato che esiste già un marchio con lo stesso nome e si richiede di inserire un nome valido.</li>
                </ol>
            </li>
            <li>EmptyName
                <ol>
                    <li>Si segnala che il campo <i>nome</i> non può essere vuoto e si richiede di inserire un nome valido.</li>
                </ol>
            </li>
            <li>Cancel</li>
        </ol>
    </td></tr>
</table>

<table align="center">
    <tr><td width="600" align="center">
        <b>Caso d'Uso:</b> DeleteBrand
    </td></tr>
    <tr><td width="600">
        <b>ID:</b> 3
    </td></tr>
    <tr><td width="600">
        <b>Descrizione:</b> L'amministratore desidera eliminare un marchio.
    </td></tr>
    <tr><td width="600">
        <b>Attori Principali:</b> Amministratore.
    </td></tr>
    <tr><td width="600">
        <b>Attori Secondari:</b> Nessuno.
    </td></tr>
    <tr><td width="600">
        <b>Precondizioni:</b>
        <ol>
            <li>Il marchio deve esistere.</li>
            <li>Il marchio deve essere attivo.</li>
        </ol>
    </td></tr>
    <tr><td width="600">
        <b>Flusso Principale:</b>
        <ol>
            <li>Si seleziona <i>elimina</i> per il marchio che si desidera cancellare.</li>
            <li>Si conferma la cancellazione del marchio facendo clic su <i>accetta</i>.</li>
        </ol>
    </td></tr>
    <tr><td width="600">
        <b>Postcondizioni:</b>
        <ol>
            <li>Si procede con la disattivazione logica, modificando il campo <i>attivo</i> del marchio selezionato in <i>false</i>.</li>
        </ol>
    </td></tr>
    <tr><td width="600">
        <b>Flussi Alternativi:</b>
        <ol>
            <li>Cancel</li>
        </ol>
    </td></tr>
</table>

<table align="center">
    <tr><td width="600" align="center">
        <b>Caso d'Uso:</b> CreateCategory
    </td></tr>
    <tr><td width="600">
        <b>ID:</b> 4
    </td></tr>
    <tr><td width="600">
        <b>Descrizione:</b> L'amministratore desidera creare una nuova categoria di prodotti.
    </td></tr>
    <tr><td width="600">
        <b>Attori Principali:</b> Amministratore.
    </td></tr>
    <tr><td width="600">
        <b>Attori Secondari:</b> Nessuno.
    </td></tr>
    <tr><td width="600">
        <b>Precondizioni:</b> Nessuna.
    </td></tr>
    <tr><td width="600">
        <b>Flusso Principale:</b>
        <ol>
            <li>Nella sezione <i>nuova categoria</i> si inserisce il nome della stessa.</li>
            <li>Si seleziona <i>salva</i>.</li>
            <li>Vengono convalidati i dati.</li>
        </ol>
    </td></tr>
    <tr><td width="600">
        <b>Postcondizioni:</b>
        <ol>
            <li>Viene creata una nuova categoria.</li>
        </ol>
    </td></tr>
    <tr><td width="600">
        <b>Flussi Alternativi:</b>
        <ol>
            <li>InactivElement
            <ol>
                <li>La categoria esiste nel database ma era stata disattivata in precedenza. Viene riattivata modificando il suo stato <i>attivo</i> a <i>true</i>.</li>
            </ol></li>
            <li>InvalidName
            <ol>
                <li>La categoria esiste nel database ed è attiva. Viene segnalato che esiste già una categoria con lo stesso nome e si richiede di inserire un nome valido.</li>
            </ol></li>
            <li>EmptyName
            <ol>
                <li>Si segnala che il campo <i>nome</i> non può essere vuoto e si richiede di inserire un nome valido.</li>
            </ol></li>
            <li>Cancel</li>
        </ol>
    </td></tr>
</table>

<table align="center">
    <tr><td width="600" align="center">
        <b>Caso d'Uso:</b> UpdateCategory
    </td></tr>
    <tr><td width="600">
        <b>ID:</b> 5
    </td></tr>
    <tr><td width="600">
        <b>Descrizione:</b> L'amministratore desidera modificare una categoria.
    </td></tr>
    <tr><td width="600">
        <b>Attori Principali:</b> Amministratore.
    </td></tr>
    <tr><td width="600">
        <b>Attori Secondari:</b> Nessuno.
    </td></tr>
    <tr><td width="600">
        <b>Precondizioni:</b>
        <ol>
            <li>La categoria deve esistere.</li>
        </ol>
    </td></tr>
    <tr><td width="600">
        <b>Flusso Principale:</b>
        <ol>
            <li>Si seleziona <i>modifica</i> nella categoria che si desidera modificare.</li>
            <li>Nella sezione <i>modifica categoria</i> si inserisce il nuovo nome.</li>
            <li>Si seleziona <i>salva</i>.</li>
        </ol>
    </td></tr>
    <tr><td width="600">
        <b>Poscondizioni:</b>
        <ol>
            <li>La categoria selezionata viene modificata.</li>
        </ol>
    </td></tr>
    <tr><td width="600">
        <b>Flussi Alternativi:</b>
        <ol>
            <li>InactiveElement
            <ol>
                <li>La categoria esiste nel database ma era stata disattivata in precedenza. Viene riattivata modificando il suo stato <i>attivo</i> a <i>true</i> e la categoria attuale viene disattivata logicamente.</li>
            </ol></li>
            <li>InvalidName
            <ol>
                <li>La categoria esiste nel database ed è attiva. Viene segnalato che esiste già una categoria con lo stesso nome e si richiede di inserire un nome valido.</li>
            </ol></li>
            <li>EmptyName
            <ol>
                <li>Si segnala che il campo <i>nome</i> non può essere vuoto e si richiede di inserire un nome valido.</li>
            </ol></li>
            <li>Cancel</li>
        </ol>
    </td></tr>
</table>

<table align="center">
    <tr><td width="600" align="center">
        <b>Caso d'Uso:</b> DeleteCategory
    </td></tr>
    <tr><td width="600">
        <b>ID:</b> 6
    </td></tr>
    <tr><td width="600">
        <b>Descrizione:</b> L'amministratore desidera eliminare una categoria.
    </td></tr>
    <tr><td width="600">
        <b>Attori Principali:</b> Amministratore.
    </td></tr>
    <tr><td width="600">
        <b>Attori Secondari:</b> Nessuno.
    </td></tr>
    <tr><td width="600">
        <b>Precondizioni:</b>
        <ol>
            <li>La categoria deve esistere.</li>
            <li>La categoria deve essere attiva.</li>
        </ol>
    </td></tr>
    <tr><td width="600">
        <b>Flusso Principale:</b>
        <ol>
            <li>Si seleziona <i>elimina</i> nella categoria che si desidera cancellare.</li>
            <li>Si conferma la cancellazione della categoria facendo clic su <i>accetta</i>.</li>
        </ol>
    </td></tr>
    <tr><td width="600">
        <b>Poscondizioni:</b>
        <ol>
            <li>Si procede con la disattivazione logica, modificando il campo <i>attivo</i> della categoria selezionata in <i>false</i>.</li>
        </ol>
    </td></tr>
    <tr><td width="600">
        <b>Flussi Alternativi:</b>
        <ol>
            <li>Cancel</li>
        </ol>
    </td></tr>
</table>

<table align="center">
    <tr><td width="600" align="center">
        <b>Caso d'Uso:</b> CreateProduct
    </td></tr>
    <tr><td width="600">
        <b>ID:</b> 7
    </td></tr>
    <tr><td width="600">
        <b>Descrizione:</b> L'amministratore desidera creare un nuovo prodotto.
    </td></tr>
    <tr><td width="600">
        <b>Attori Principali:</b> Amministratore.
    </td></tr>
    <tr><td width="600">
        <b>Attori Secondari:</b> Nessuno.
    </td></tr>
    <tr><td width="600">
        <b>Precondizioni:</b> Nessuna.
    </td></tr>
    <tr><td width="600">
        <b>Flusso Principale:</b>
        <ol>
            <li>Nella sezione <i>applicazione</i> si inseriscono il codice, il nome e il prezzo. Si seleziona la marca e la categoria, se applicabile.</li>
            <li>Si seleziona <i>salva</i>.</li>
            <li>Vengono convalidati i dati.</li>
        </ol>
    </td></tr>
    <tr><td width="600">
        <b>Postcondizioni:</b>
        <ol>
            <li>Viene creato un nuovo prodotto.</li>
        </ol>
    </td></tr>
    <tr><td width="600">
        <b>Flussi Alternativi:</b>
        <ol>
            <li>InvalidCode
            <ol>
                <li>Si segnala che esiste già un prodotto con lo stesso codice e si richiede di inserire un codice valido.</li>
            </ol></li>
            <li>EmptyCode
            <ol>
                <li>Si segnala che il campo <i>codice</i> non può essere vuoto e si richiede di inserire un codice valido.</li>
            </ol></li>
            <li>InvalidName
            <ol>
                <li>Si segnala che esiste già un prodotto con lo stesso nome e si richiede di inserire un nome valido.</li>
            </ol>
            </li>
            <li>EmptyName
            <ol>
                <li>Si segnala che il campo <i>nome</i> non può essere vuoto e si richiede di inserire un nome valido.</li>
            </ol>
            </li>
            <li>EmptyPrice
            <ol>
                <li>Si segnala che il campo <i>prezzo</i> non può essere vuoto e si richiede di inserire un prezzo valido.</li>
            </ol>
            </li>
            <li>Cancel</li>
        </ol>
    </td></tr>
</table>

<table align="center">
    <tr><td width="600" align="center">
        <b>Caso d'Uso:</b> FilterProduct
    </td></tr>
    <tr><td width="600">
        <b>ID:</b> 8
    </td></tr>
    <tr><td width="600">
        <b>Descrizione:</b> L'amministratore desidera cercare uno o più prodotti.
    </td></tr>
    <tr><td width="600">
        <b>Attori Principali:</b> Amministratore.
    </td></tr>
    <tr><td width="600">
        <b>Attori Secondari:</b> Nessuno.
    </td></tr>
    <tr><td width="600">
        <b>Precondizioni:</b> Nessuna.
    </td></tr>
    <tr><td width="600">
        <b>Flusso Principale:</b>
        <ol>
            <li>Nella sezione <i>applica filtro</i> si inseriscono i caratteri per cui si desidera filtrare il nome del prodotto, la marca e/o la categoria.</li>
            <li>Si seleziona <i>cerca</i>.</li>
            <li>Vengono convalidati i dati.</li>
        </ol>
    </td></tr>
    <tr><td width="600">
        <b>Postcondizioni:</b>
        <ol>
            <li>Viene restituita una lista dei prodotti attivi filtrati.</li>
        </ol>
    </td></tr>
    <tr><td width="600">
        <b>Flussi Alternativi:</b>
        <ol>
            <li>EmptyList
            <ol>
                <li>Si segnala che non è stato trovato alcun prodotto.</li>
            </ol></li>
            <li>Cancel</li>
        </ol>
    </td></tr>
</table>

<table align="center">
    <tr><td width="600" align="center">
        <b>Caso d'Uso:</b> UpdateProduct
    </td></tr>
    <tr><td width="600">
        <b>ID:</b> 9
    </td></tr>
    <tr><td width="600">
        <b>Descrizione:</b> L'amministratore desidera modificare un prodotto.
    </td></tr>
    <tr><td width="600">
        <b>Attori Principali:</b> Amministratore.
    </td></tr>
    <tr><td width="600">
        <b>Attori Secondari:</b> Nessuno.
    </td></tr>
    <tr><td width="600">
        <b>Precondizioni:</b>
        <ol>
            <li>Il prodotto deve esistere.</li>
            <li>Il prodotto deve essere attivo.</li>
        </ol>
    </td></tr>
    <tr><td width="600">
        <b>Flusso Principale:</b>
        <ol>
            <li>Si seleziona <i>modifica</i> sul prodotto che si desidera modificare.</li>
            <li>Nella sezione <i>modifica prodotto</i> si inseriscono i dati da modificare (codice, nome, prezzo, marca e/o categoria).</li>
            <li>Si seleziona <i>salva</i>.</li>
            <li>Vengono convalidati i dati.</li>
        </ol>
    </td></tr>
    <tr><td width="600">
        <b>Postcondizioni:</b>
        <ol>
            <li>Il prodotto selezionato viene modificato.</li>
        </ol>
    </td></tr>
    <tr><td width="600">
        <b>Flussi Alternativi:</b>
        <ol>
            <li>InvalidCode
            <ol>
                <li>Si segnala che esiste già un prodotto con lo stesso codice e si richiede di inserire un codice valido.</li>
            </ol></li>
            <li>EmptyCode
            <ol>
                <li>Si segnala che il campo <i>codice</i> non può essere vuoto e si richiede di inserire un codice valido.</li>
            </ol></li>
            <li>InvalidName
            <ol>
                <li>Si segnala che esiste già un prodotto con lo stesso nome e si richiede di inserire un nome valido.</li>
            </ol>
            </li>
            <li>EmptyName
            <ol>
                <li>Si segnala che il campo <i>nome</i> non può essere vuoto e si richiede di inserire un nome valido.</li>
            </ol>
            </li>
            <li>EmptyPrice
            <ol>
                <li>Si segnala che il campo <i>prezzo</i> non può essere vuoto e si richiede di inserire un prezzo valido.</li>
            </ol>
            </li>
            <li>Cancel</li>
        </ol>
    </td></tr>
</table>

<table align="center">
	<tr><td width="600" align="center">
		<b>Caso d'Uso:</b> DeleteProduct
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 10
	</td></tr>
	<tr><td width="600">
		<b>Descrizione:</b> L'amministratore desidera eliminare un prodotto.
	</td></tr>
	<tr><td width="600">
		<b>Attori Principali:</b> Amministratore.
	</td></tr>
	<tr><td width="600">
		<b>Attori Secondari:</b> Nessuno.
	</td></tr>
	<tr><td width="600">
		<b>Precondizioni:</b>
		<ol>
			<li>Il prodotto deve esistere.</li>
			<li>Il prodotto deve essere attivo.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flusso Principale:</b>
		<ol>
			<li>Si seleziona <i>elimina</i> sul prodotto che si desidera eliminare.</li>
			<li>Si conferma l'eliminazione del prodotto facendo clic su <i>accetta</i>.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Postcondizioni:</b>
		<ol>
			<li>Viene eseguita la cancellazione logica, modificando il campo <i>attivo</i> del prodotto selezionato in <i>false</i>.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flussi Alternativi:</b>
		<ol>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600" align="center">
		<b>Caso d'Uso:</b> CreateBartable
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 11
	</td></tr>
	<tr><td width="600">
		<b>Descrizione:</b> L'amministratore desidera creare un nuovo tavolo.
	</td></tr>
	<tr><td width="600">
		<b>Attori Principali:</b> Amministratore.
	</td></tr>
	<tr><td width="600">
		<b>Attori Secondari:</b> Nessuno.
	</td></tr>
	<tr><td width="600">
		<b>Precondizioni:</b> Nessuna.
	</td></tr>
	<tr><td width="600">
		<b>Flusso Principale:</b>
		<ol>
			<li>Nella sezione <i>nuovo tavolo</i> si inserisce il numero corrispondente al tavolo.</li>
			<li>Si seleziona <i>salva</i>.</li>
			<li>Vengono convalidati i dati.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Postcondizioni:</b>
		<ol>
			<li>Viene creato un nuovo tavolo.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flussi Alternativi:</b>
		<ol>
			<li>InactiveElement
			<ol>
				<li>Il tavolo esiste nel database, ma è stato disattivato in precedenza. Viene riattivato modificando il suo stato <i>attivo</i> in <i>true</i>.</li>
			</ol></li>
			<li>InvalidNumber
			<ol>
				<li>Il tavolo esiste nel database ed è attivo. Si segnala che esiste già un tavolo con lo stesso numero e si richiede di inserire un numero valido.</li>
			</ol></li>
			<li>EmptyNumber
			<ol>
				<li>Si segnala che il campo <i>numero</i> non può essere vuoto e si richiede di inserire un numero valido.</li>
			</ol></li>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600" align="center">
		<b>Caso d'Uso:</b> UpdateBartable
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 12
	</td></tr>
	<tr><td width="600">
		<b>Descrizione:</b> L'amministratore desidera modificare un tavolo.
	</td></tr>
	<tr><td width="600">
		<b>Attori Principali:</b> Amministratore.
	</td></tr>
	<tr><td width="600">
		<b>Attori Secondari:</b> Nessuno.
	</td></tr>
	<tr><td width="600">
		<b>Precondizioni:</b> 
		<ol>
			<li>Il tavolo deve esistere.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flusso Principale:</b>
		<ol>
			<li>Si seleziona <i>modifica</i> sul tavolo che si desidera modificare.</li>
			<li>Nella sezione <i>modifica tavolo</i> si inserisce il nuovo numero del tavolo.</li>
			<li>Si seleziona <i>salva</i>.</li>
			<li>Vengono convalidati i dati.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Postcondizioni:</b>
		<ol>
			<li>Viene modificato il tavolo selezionato.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flussi Alternativi:</b>
		<ol>
			<li>InactiveElement
			<ol>
				<li>Il tavolo esiste nel database, ma è stato disattivato in precedenza. Viene riattivato modificando il suo stato <i>attivo</i> in <i>true</i> e il tavolo attuale viene disattivato logicamente.</li>
			</ol></li>
			<li>EmptyName
			<ol>
				<li>Si segnala che il campo <i>numero</i> non può essere vuoto e si richiede di inserire un numero valido.</li>
			</ol></li>
			<li>InvalidName
			<ol>
				<li>Si segnala che esiste già un tavolo con lo stesso numero e si richiede di inserire un numero valido.</li>
			</ol></li>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600" align="center">
		<b>Caso d'Uso:</b> DeleteBartable
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 13
	</td></tr>
	<tr><td width="600">
		<b>Descrizione:</b> L'amministratore desidera eliminare un tavolo.
	</td></tr>
	<tr><td width="600">
		<b>Attori Principali:</b> Amministratore.
	</td></tr>
	<tr><td width="600">
		<b>Attori Secondari:</b> Nessuno.
	</td></tr>
	<tr><td width="600">
		<b>Precondizioni:</b>
		<ol>
			<li>Il tavolo deve esistere.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flusso Principale:</b>
		<ol>
			<li>Si seleziona <i>elimina</i> sul tavolo che si desidera eliminare.</li>
			<li>Si conferma l'eliminazione del tavolo facendo clic su <i>accetta</i>.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Postcondizioni:</b>
		<ol>
			<li>Viene eseguita la cancellazione logica, modificando il campo <i>attivo</i> del tavolo selezionato in <i>false</i>.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flussi Alternativi:</b>
		<ol>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600" align="center">
		<b>Caso d'Uso:</b> CreatePaymentMethod
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 14
	</td></tr>
	<tr><td width="600">
		<b>Descrizione:</b> L'amministratore desidera creare un nuovo metodo di pagamento.
	</td></tr>
	<tr><td width="600">
		<b>Attori Principali:</b> Amministratore.
	</td></tr>
	<tr><td width="600">
		<b>Attori Secondari:</b> Nessuno.
	</td></tr>
	<tr><td width="600">
		<b>Precondizioni:</b> Nessuna.
	</td></tr>
	<tr><td width="600">
		<b>Flusso Principale:</b>
		<ol>
			<li>Nella sezione <i>nuovo metodo di pagamento</i> si inserisce il nome dello stesso.</li>
			<li>Si seleziona <i>salva</i>.</li>
			<li>Vengono convalidati i dati.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Postcondizioni:</b>
		<ol>
			<li>Viene creato un nuovo metodo di pagamento.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flussi Alternativi:</b>
		<ol>
			<li>InactiveElement
			<ol>
				<li>Il metodo di pagamento esiste nel database, ma è stato disattivato in precedenza. Viene riattivato modificando il suo stato <i>attivo</i> a <i>true</i>.</li>
			</ol></li>
			<li>InvalidName
			<ol>
				<li>Il metodo di pagamento esiste nel database ed è attivo. Viene segnalato che esiste già un metodo di pagamento con lo stesso nome e si richiede di inserire un nome valido.</li>
			</ol></li>
			<li>EmptyName
			<ol>
				<li>Si segnala che il campo <i>nome</i> non può essere vuoto e si richiede di inserire un nome valido.</li>
			</ol></li>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600" align="center">
		<b>Caso d'Uso:</b> UpdatePaymentMethod
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 15
	</td></tr>
	<tr><td width="600">
		<b>Descrizione:</b> L'amministratore desidera modificare un metodo di pagamento.
	</td></tr>
	<tr><td width="600">
		<b>Attori Principali:</b> Amministratore.
	</td></tr>
	<tr><td width="600">
		<b>Attori Secondari:</b> Nessuno.
	</td></tr>
	<tr><td width="600">
		<b>Precondizioni:</b>
		<ol>
			<li>Il metodo di pagamento deve esistere.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flusso Principale:</b>
		<ol>
			<li>Si seleziona <i>modifica</i> nel metodo di pagamento che si desidera modificare.</li>
			<li>Nella sezione <i>modifica metodo di pagamento</i> si inserisce il nuovo metodo di pagamento.</li>
			<li>Si seleziona <i>salva</i>.</li>
			<li>Vengono convalidati i dati.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Postcondizioni:</b>
		<ol>
			<li>Viene modificato il metodo di pagamento selezionato.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flussi Alternativi:</b>
		<ol>
			<li>InactiveElement
			<ol>
				<li>Il metodo di pagamento esiste nel database, ma è stato disattivato in precedenza. Viene riattivato modificando il suo stato <i>attivo</i> a <i>true</i> e il metodo di pagamento attuale viene disattivato logicamente.</li>
			</ol></li>
			<li>InvalidName
			<ol>
				<li>Il metodo di pagamento esiste nel database ed è attivo. Viene segnalato che esiste già un metodo di pagamento con lo stesso nome e si richiede di inserire un nome valido.</li>
			</ol></li>
			<li>EmptyName
			<ol>
				<li>Si segnala che il campo <i>nome</i> non può essere vuoto e si richiede di inserire un nome valido.</li>
			</ol></li>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600" align="center">
		<b>Caso d'Uso:</b> OpenSale
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 16
	</td></tr>
	<tr><td width="600">
		<b>Descrizione:</b> L'utente desidera generare una nuova vendita.
	</td></tr>
	<tr><td width="600">
		<b>Attori Principali:</b> Utente.
	</td></tr>
	<tr><td width="600">
		<b>Attori Secondari:</b> Nessuno.
	</td></tr>
	<tr><td width="600">
		<b>Precondizioni:</b>
		<ol>
			<li>Deve esistere almeno un tavolo.</li>
			<li>Il tavolo non deve avere una vendita attiva associata.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flusso Principale:</b>
		<ol>
			<li>Nella sezione <i>nuova vendita</i> si seleziona il numero corrispondente al tavolo del cliente.</li>
			<li>Si seleziona <i>apri tavolo</i>.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Postcondizioni:</b>
		<ol>
			<li>Viene creata una nuova vendita con il valore <i>true</i> per il campo <i>aperta</i>.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flussi Alternativi:</b>
		<ol>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600" align="center">
		<b>Caso d'Uso:</b> AddProductToSale
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 17
	</td></tr>
	<tr><td width="600">
		<b>Descrizione:</b> L'utente desidera aggiungere prodotti a una vendita attiva.
	</td></tr>
	<tr><td width="600">
		<b>Attori Principali:</b> Utente.
	</td></tr>
	<tr><td width="600">
		<b>Attori Secondari:</b> Nessuno.
	</td></tr>
	<tr><td width="600">
		<b>Precondizioni:</b>
		<ol>
			<li>La vendita deve esistere.</li>
			<li>La vendita deve essere attiva.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flusso Principale:</b>
		<ol>
			<li>Nella sezione <i>vendite attive</i> si seleziona <i>visualizza tavolo</i> nella vendita a cui si desidera aggiungere prodotti.</li>
			<li>Nella sezione <i>aggiungi prodotti</i> si seleziona il prodotto da aggiungere inserendo il codice o il nome e la quantità desiderata.</li>
			<li>Si seleziona <i>aggiungi</i>.</li>
			<li>Vengono convalidati i dati.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Postcondizioni:</b>
		<ol>
			<li>Viene generata un'istanza della classe <i>ProdottoVenduto</i> con i dati del prodotto venduto, la quantità di unità, il subtotale (prezzo*unità) e la vendita a cui è associato.</li>
			<li>Viene aggiornato il campo <i>totale</i> (importo da pagare dal cliente) della vendita attiva selezionata.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flussi Alternativi:</b>
		<ol>
			<li>EmptyUnits
			<ol>
				<li>Si segnala che il campo <i>unità</i> non può essere vuoto e si richiede di inserire un numero di unità valido.</li>
			</ol></li>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600" align="center">
		<b>Caso d'Uso:</b> DeleteProductFromSale
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 18
	</td></tr>
	<tr><td width="600">
		<b>Descrizione:</b> L'utente desidera rimuovere prodotti da una vendita attiva.
	</td></tr>
	<tr><td width="600">
		<b>Attori Principali:</b> Utente.
	</td></tr>
	<tr><td width="600">
		<b>Attori Secondari:</b> Nessuno.
	</td></tr>
	<tr><td width="600">
		<b>Precondizioni:</b>
		<ol>
			<li>La vendita deve esistere.</li>
			<li>La vendita deve essere attiva.</li>
			<li>L'istanza della classe <i>ProdottoVenduto</i> a cui corrisponde il prodotto che si desidera eliminare deve esistere.</li>
			<li>L'istanza della classe <i>ProdottoVenduto</i> a cui corrisponde il prodotto che si desidera eliminare deve essere associata alla vendita attiva.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flusso Principale:</b>
		<ol>
			<li>Nella sezione <i>vendite attive</i> si seleziona <i>visualizza vendita</i> nella vendita da cui si desidera rimuovere il prodotto.</li>
			<li>Nella sezione <i>vendite del tavolo</i> si seleziona il prodotto che si desidera eliminare facendo clic su <i>rimuovi</i>.</li>
			<li>Si conferma la rimozione del prodotto facendo clic su <i>accetta</i>.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Postcondizioni:</b>
		<ol>
			<li>L'istanza della classe <i>ProdottoVenduto</i> viene eliminata dal database.</li>
			<li>Viene aggiornato il campo <i>totale</i> (importo da pagare dal cliente) della vendita attiva selezionata.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flussi Alternativi:</b>
		<ol>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600" align="center">
		<b>Caso d'Uso:</b> CloseSale
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 19
	</td></tr>
	<tr><td width="600">
		<b>Descrizione:</b> L'utente desidera chiudere una vendita attiva.
	</td></tr>
	<tr><td width="600">
		<b>Attori Principali:</b> Utente.
	</td></tr>
	<tr><td width="600">
		<b>Attori Secondari:</b> Nessuno.
	</td></tr>
	<tr><td width="600">
		<b>Precondizioni:</b> 
		<ol>
			<li>La vendita deve esistere.</li>
			<li>La vendita deve essere attiva.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flusso Principale:</b>
		<ol>
			<li>Nella sezione <i>vendite attive</i> si seleziona <i>visualizza tavolo</i> nella vendita che si desidera chiudere.</li>
			<li>Si seleziona <i>chiudi tavolo</i>.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Postcondizioni:</b>
		<ol>
			<li>Viene modificato il valore del campo <i>aperta</i> della vendita selezionata diventando <i>false</i>.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flussi Alternativi:</b>
		<ol>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>

<table align="center">
	<tr><td width="600" align="center">
		<b>Caso d'Uso:</b> ViewSale
	</td></tr>
	<tr><td width="600">
		<b>ID:</b> 20
	</td></tr>
	<tr><td width="600">
		<b>Descrizione:</b> L'utente desidera visualizzare le vendite di una data specifica o di un intervallo di date.
	</td></tr>
	<tr><td width="600">
		<b>Attori Principali:</b> Utente.
	</td></tr>
	<tr><td width="600">
		<b>Attori Secondari:</b> Nessuno.
	</td></tr>
	<tr><td width="600">
		<b>Precondizioni:</b>
		<ol>
			<li>Deve esistere almeno una vendita.</li>
			<li>La data non può essere nel futuro.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flusso Principale:</b>
		<ol>
			<li>Nella sezione <i>seleziona date</i> si scelgono le date <i>da</i> e <i>a</i> entro le quali si desidera visualizzare le vendite.</li>
			<li>Si seleziona <i>cerca</i>.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Postcondizioni:</b>
		<ol>
			<li>Viene generata una vista con il totale dei ricavi ottenuti nell'intervallo di date selezionato.</li>
			<li>Viene generata una vista con un elenco del totale delle unità vendute di ciascun prodotto.</li>
		</ol>
	</td></tr>
	<tr><td width="600">
		<b>Flussi Alternativi:</b>
		<ol>
			<li>Cancel</li>
		</ol>
	</td></tr>
</table>
