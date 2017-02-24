Vytvoøení tabulek v postgresql databázi, aby aplikace byla funkèní:
# vytvoreni databaze
psql -U postgre -W
CREATE DATABASE morosystems TEMPLATE template0 ENCODING 'UTF8';
# vytvoreni schematu
\connect morosystems
CREATE SCHEMA morosystems;
CREATE USER morosystems PASSWORD 'morosystems';
GRANT ALL ON SCHEMA morosystems TO morosystems;
GRANT ALL ON ALL TABLES IN SCHEMA morosystems TO morosystems;
\q


# vytvoreni tabulek
# pokud hlasi terminal psql: FATAL:  Peer authentication failed for user "morosystems"
# je potreba zmenit v souboru
# sudo vim /etc/postgresql/9.5/main/pg_hba.conf
# z
# local   all             postgres                                peer
# na
# local   all             postgres                                md5
# nezapomenout pote restart psql
# sudo service postgresql restart
# viz. http://stackoverflow.com/questions/18664074/getting-error-peer-authentication-failed-for-user-postgres-when-trying-to-ge
#
psql -d morosystems -U morosystems -W
CREATE TABLE morosystems.user2Table
(id SERIAL NOT NULL,
firstname VARCHAR(256) NOT NULL,
lastname VARCHAR(256) NOT NULL,
email VARCHAR(256) NOT NULL,
telephone VARCHAR(256) NOT NULL,
PRIMARY KEY (id)
);
# vlozeni testovacich dat
INSERT INTO morosystems.user2Table (id, firstname, lastname, email, telephone) VALUES (1, 'Pepa', 'Dvorak', 'pepadvorak@dvorakovci.cz', '789456123');
INSERT INTO morosystems.user2Table (id, firstname, lastname, email, telephone) VALUES (2, 'Franta', 'Jednicka', 'franta.jednicka2k@mistr.cz', '123456789');
INSERT INTO morosystems.user2Table (id, firstname, lastname, email, telephone) VALUES (3, 'Alois', 'Makak', 'makak@srozumem.cz', '789000000');
