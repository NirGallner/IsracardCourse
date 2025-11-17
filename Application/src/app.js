const express = require('express');
const app = express();
const path = require('path');
const router = express.Router();
var port = process.env.PORT || 8080;


// Default values for init status values
var liveliness_new = 200
var readiness_new = 200


// Route application to index.html file.
router.get('/',function(req,res){
  res.sendFile(path.join(__dirname+'/html/index.html'));
  //__dirname : It will resolve to your project folder.
});

// Health Probe - Application Liveliness
router.get('/health/liveliness',function(req,res){
    console.log(`code ----> ${liveliness_new}`)
    res.status(parseInt(liveliness_new))
      if (liveliness_new > 399){
        res.send('Not Healthy')
      }
      else{ res.send('Healthy')}
  });

// Health Probe - Application Readiness
router.get('/health/readiness',function(req,res){
  console.log(`code ----> ${readiness_new}`)
  res.status(parseInt(readiness_new))
    if (readiness_new > 399){
      res.send('Not Ready')
    }
    else{ res.send('Ready')}
    
  });  
// Change Health probe status
router.get('/liveliness/:statuse', function(req,res){
  var l_statuse = req.params['statuse'];
  console.log(l_statuse)
  liveliness_new = l_statuse;
  console.log(`New status code set ${l_statuse}`)
  res.redirect('/')
});
// Change Readiness probe status
router.get('/readiness/:statuse', function(req,res){
  var r_statuse = req.params['statuse'];
  console.log(r_statuse)
  readiness_new = r_statuse;
  console.log(`New status code set ${r_statuse}`)
  res.redirect('/')
});

//add the router
app.use('/', router);
app.listen(port);

console.log(`Running at Port ${port}`);