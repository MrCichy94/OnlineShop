TweenMax.defaultEase = Linear.easeOut;

new fullpage("#fullpage", {
  autoScrolling: true,
  navigation: true,
  onLeave: (origin, destination, direction) => {
    const section = destination.item;
    /*
    var v1 = document.getElementById("myVideo1");
    */
    var v2 = document.getElementById("myVideo2");
    
    if (destination.index === 0 || destination.index === 1 || destination.index === 2 || destination.index === 4) {
      /*
      if (v1.paused) {
        v1.play();
      }
      */
      if (v2.paused) {
        v2.play();
      }
      
    } 
  }
});
