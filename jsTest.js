const fs = require('fs');

fs.readFile('spaces.json', 'utf-8', (err, data) => {
  const jsonData = JSON.parse(data);

  jsonData.folders.forEach((folder) => {
    folder.lists.forEach((list) => {
      console.log(`List ID: ${list.id}`);

      if (list.name.toLowerCase().startsWith('test')) {
        console.log(
          `Space Name: ${list.space.name}, Space ID: ${list.space.id}`
        );
      }
    });
  });
});
