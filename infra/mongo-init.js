db.createUser(
    {
      user: "elo7",
      pwd: "elo7",
      roles: [
        {
          role: "readWrite",
          db: "probedb"
        }
      ]
    }
);