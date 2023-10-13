<script setup>
import Cookies from 'js-cookie';
import jwt_decode from 'jwt-decode';

const books = ref([]);
const getBorrowingRecord = () => {
  const tokenWithoutBearer = Cookies.get('jwt_token').replace('Bearer ', '');
    // 解析JWT Token
    const decodedToken = jwt_decode(tokenWithoutBearer);

    // 获取subject
    const userId = decodedToken.sub;
    console.log('userId:', userId);

  fetch("http://localhost:8080/borrow_records_user?userId=" + userId)
    .then(response => response.json())
    .then(data => {
      books.value = data;
    })
    .catch(error => console.log('error', error));
};

const returnBook = (id, inventoryId) => {
  // const tokenWithoutBearer = Cookies.get('jwt_token').replace('Bearer ', '');
  //   // 解析JWT Token
  //   const decodedToken = jwt_decode(tokenWithoutBearer);

  //   // 获取subject
  //   const userId = decodedToken.sub;
  //   console.log('userId:', userId);

  console.log(id)

  const data = new FormData();
  data.append('id', id);

  fetch("http://localhost:8080/return_borrow_record", {
    method: "PUT",
    body: data
  })
    .then(response => {
      updateBookStatus(inventoryId)
    })
    .catch(error => console.log('error', error));
};

const updateBookStatus = (inventoryId) => {
  const data = new FormData();
  data.append('id', inventoryId);
  data.append('status', "IN_STOCK"); // 添加 bookId 到 FormData

  fetch("http://localhost:8080/update_inventory", {
    method: "PUT",
    body: data
  })
    .then(response => {
      window.location.reload();
    })
    .catch(error => console.log('error', error));
};

onMounted(() => {
  console.log("onMounted books");
  getBorrowingRecord();
});
</script>

<template>
  <VRow>
    <VCol cols="12">
      <VCard title="Borrowing Record">
        <VCardText>
          ...
        </VCardText>
        <VTable height="100%">
          <thead>
            <tr>
              <th class="text-uppercase text-center">
                bookId 
              </th>
              <th class="text-uppercase text-center">
                Borrow Date
              </th>
              <th class="text-uppercase text-center">
                Return Date
              </th>
              <th class="text-uppercase text-center">
                Action
              </th>
            </tr>
          </thead>

          <tbody>
            <tr v-for="item in books" :key="item.id">
              <td>
                {{ item.bookId }}
              </td>
              <td class="text-center">
                {{ item.borrowDate }}
              </td>
              <td class="text-center">
                {{ item.returnDate }}
              </td>
              <td>
                <VBtn v-if="item.returnDate === null" 
                  @click="returnBook(item.id, item.inventoryId)">
                  Return
                </VBtn>
              </td>
            </tr>
          </tbody>
        </VTable>
      </VCard>
    </VCol>
  </VRow>
</template>
