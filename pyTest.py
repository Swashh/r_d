import json

with open('spaces.json', 'r', encoding='utf-8') as f:
    data = json.load(f)

for folder in data.get('folders', []):
    for lst in folder.get('lists', []):
        print(f"List ID: {lst['id']}")
        
        if lst['name'].lower().startswith('test'):
            space = lst.get('space', {})
            print(f"Space Name: {space.get('name', 'Unknown')}, Space ID: {space.get('id', 'Unknown')}")
