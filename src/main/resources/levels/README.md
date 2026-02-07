# How to add to resources

Each folder contains information on a level based on the name

## level.csv
*A csv file containing information on the level design. 
Please look [here](https://docs.google.com/spreadsheets/d/1YyVf_IwWB_XYJB_9f7PEmbEgjVSqCoR7jnTbRngjlos/edit?usp=sharing) 
for more details*

## config.json

Example layout looks like this

```json
{
  "name": "Add 1 up",
  "width": 10,
  "height": 10,

  "inputCards": [
    { "suit": "HEART", "value": 7, "material": "GLASS" },
    { "suit": "SPADE", "value": 10, "material": "PLASTIC" }
  ],

  "outputCards": [
    { "suit": "HEART", "value": 8},
    { "suit": "SPADE", "value": 11}
  ]
}
```



