db = db.getSiblingDB('workshop_mongo');
db.createUser({
  user: 'devuser',
  pwd: 'devpass',
  roles: [{ role: 'readWrite', db: 'workshop_mongo' }]
});
 
