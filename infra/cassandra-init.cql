CREATE KEYSPACE IF NOT exists probedb
WITH replication = {'class':'SimpleStrategy', 'replication_factor':1};

CREATE TYPE IF NOT EXISTS probedb.probeentity (id uuid, price decimal);

CREATE TABLE IF NOT EXISTS probedb.probeentity(
   id uuid,
   name text,
   probeentities list<frozen<probeentity>>,
   x int,
   y int,
   primary key(id)
);