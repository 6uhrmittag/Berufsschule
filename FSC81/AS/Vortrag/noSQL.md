# thema noSQL - mapreduce


# vorgabe
NoSQL
MapReduce	Warum?
Prinzip
Beispiel
Hadoop

Frameworks: 1 Seite (Empfehlung: Palatino Linotype  11, Zeilenabstand 1,15)
## handout

# Source https://www.youtube.com/watch?v=qI_g07C_Q5I - GOTO 2012 • Introduction to NoSQL • Martin Fowler

# noSQL Basics
- Begriff "noSQL" war eigentlich nur ein Twitter Hashtag für ein Meetup
- Typical characteristics of NoSQL (not absolute)
    - non-relational
    - open-source
    - cluster-friendly
    - 21st Century Web culture
    - schema-less
- Beispiele
    - redis (Datamodel: Key-value)
    - riak (Datamodel: Key-value)
    - apache hbase (Datamode: Column family)
    - couchDB (Datamodel: Document)
    - mongoDB (Datamodel: Document)
    - Neo4j (Datamodel: Graph)
- Datamodels
    - Key-value
        - "Gib mir den Wert an diesem Schlüssel" - die DB weiß nichts über die Eigenschaft -> hashmap
    - Document
        - "Menge an beliebigen Dokumenten, die jeweils selb st komplex und ohne festes Schema". Üblicherweise json, aber kein muss
        
