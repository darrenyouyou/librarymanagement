<script setup>
import { onMounted, ref } from 'vue';

const books = ref([]);
const getInventory = () => {
  fetch("http://localhost:8080/inventories")
    .then(response => response.json())
    .then(data => {
      books.value = data;
    })
    .catch(error => console.log('error', error));
};

onMounted(() => {
  console.log("onMounted books");
  getInventory();
});
</script>

<script>
const br = ref([]);
const br2 = ref([]);

export default {
  methods: {
  editItem(inventoryId, isbn) {
    console.log('Clicked on ISBN:', isbn);
    const data = new FormData();
    data.append('userId', '1');
    data.append('bookId', isbn);
    data.append('inventoryId', inventoryId);

    fetch("http://localhost:8080/insert_borrow_record", {
      method: "POST",
      body: data
    })
      .then(response => response.json())
      .then(data => {
        console.log(data);
        const id = data.id; 
        br.value = id; 
        this.upDateItem(inventoryId)
      })
      .catch(error => console.log('error', error));
  },
  upDateItem(inventoryId) {
  const data = new FormData();
  data.append('id', inventoryId);
  data.append('status', "BORROWED"); // 添加 bookId 到 FormData

  fetch("http://localhost:8080/update_inventory", {
    method: "PUT",
    body: data
  })
    .then(response => {
      window.location.reload();
    })
    .catch(error => console.log('error', error));
}

  
}
}
</script>

<template>
  <VRow>
    <VCol cols="12">
      <VCard title="Inventory">
        <VCardText>
        </VCardText>
        <VTable height="100%">
          <thead>
            <tr>
              <th class="text-uppercase">
                id
              </th>
              <th class="text-uppercase text-center">
                ISBN
              </th>
              <th class="text-uppercase text-center">
                storeTime
              </th>
              <th class="text-uppercase text-center">
                status
              </th>
              <th class="text-uppercase text-center">
                Action
              </th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="book in books" :key="book.id">
              <td>{{ book.id }}</td>
              <td class="text-center">{{ book.isbn }}</td>
              <td class="text-center">{{ book.storeTime }}</td>
              <td class="text-center">{{ book.status}}</td>
              <td>
                <v-icon v-if="false"
                   size="small"
                  class="me-2"
                  @click="editItem(book.id, book.bookId)"
                  >
                  mdi-exit-to-app
                </v-icon>
                <VBtn v-if="book.status === 'IN_STOCK'" 
                  @click="editItem(book.id, book.bookId)">
                  Borrow
                </VBtn>
              </td>
            </tr>
          </tbody>
        </VTable>
      </VCard>
    </VCol>
  </VRow>
</template>
