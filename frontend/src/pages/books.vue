<script setup>

const books = [
  {
    dessert: 'Frozen Yogurt',
    calories: 159,
    fat: 6,
    carbs: 24,
    protein: 4,
  },
  {
    dessert: 'Ice cream sandwich',
    calories: 237,
    fat: 6,
    carbs: 24,
    protein: 4,
  },
  {
    dessert: 'Eclair',
    calories: 262,
    fat: 6,
    carbs: 24,
    protein: 4,
  },
  {
    dessert: 'Cupcake',
    calories: 305,
    fat: 6,
    carbs: 24,
    protein: 4,
  },
  {
    dessert: 'Gingerbread',
    calories: 356,
    fat: 6,
    carbs: 24,
    protein: 4,
  },
]

const getAllbooks = (() => {

  var requestOptions = {
    method: 'GET',
    redirect: 'follow'
  };

  fetch("http://localhost:8080/books", requestOptions)
    .then(response => response.text())
    .then(result => console.log(result))
    .catch(error => console.log('error', error));
})

onMounted(() => {
  //  頁面完成渲染後首先會執行的 function
  console.log("onMounted books")

  //  取得所有書籍
  getAllbooks()
})
</script>

<template>
  <VRow>
    <VCol cols="12">
      <VCard title="Books">
        <VCardText>
          ...
        </VCardText>
        <VTable height="100%">
          <thead>
            <tr>
              <th class="text-uppercase">
                books(100g Servings)
              </th>
              <th class="text-uppercase text-center">
                calories
              </th>
              <th class="text-uppercase text-center">
                Fat(g)
              </th>
              <th class="text-uppercase text-center">
                Carbs(g)
              </th>
              <th class="text-uppercase text-center">
                protein(g)
              </th>
            </tr>
          </thead>

          <tbody>
            <tr v-for="item in books" :key="item.dessert">
              <td>
                {{ item.dessert }}
              </td>
              <td class="text-center">
                {{ item.calories }}
              </td>
              <td class="text-center">
                {{ item.fat }}
              </td>
              <td class="text-center">
                {{ item.carbs }}
              </td>
              <td class="text-center">
                {{ item.protein }}
              </td>
            </tr>
          </tbody>
        </VTable>
      </VCard>
    </VCol>
  </VRow>
</template>
