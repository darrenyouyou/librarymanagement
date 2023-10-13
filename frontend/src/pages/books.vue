<script setup>
import { ref, onMounted } from 'vue';

const books = ref([]);

const getAllBooks = () => {
  fetch("http://localhost:8080/books")
    .then(response => response.json())
    .then(data => {
      books.value = data;
    })
    .catch(error => console.log('error', error));
};

onMounted(() => {
  console.log("onMounted books");
  getAllBooks();
});
</script>
<template>
  <VRow>
    <VCol cols="12">
      <VCard title="Books">
        <VCardText>
        </VCardText>
        <VTable height="100%">
          <thead>
            <tr>
              <th class="text-uppercase">
                ISBN
              </th>
              <th class="text-uppercase text-center">
                Author
              </th>
              <th class="text-uppercase text-center">
                Name
              </th>
              <th class="text-uppercase text-center">
                Introduction
              </th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="book in books" :key="book.isbn">
              <td>{{ book.isbn }}</td>
              <td class="text-center">{{ book.author }}</td>
              <td class="text-center">{{ book.name }}</td>
              <td class="text-center">{{ book.introduction }}</td>
            </tr>
          </tbody>
        </VTable>
      </VCard>
    </VCol>
  </VRow>
</template>

