<script setup>
import Cookies from 'js-cookie';
import jwt_decode from 'jwt-decode';

const totalProfit = {
  title: 'Total Profit',
  color: 'secondary',
  icon: 'mdi-poll',
  stats: '$25.6k',
  change: 42,
  subtitle: 'Weekly Project',
}

const newProject = {
  title: 'New Project',
  color: 'primary',
  icon: 'mdi-briefcase-variant-outline',
  stats: '862',
  change: -18,
  subtitle: 'Yearly Project',
}

const initialData = (() => {
  insertUsers("0911111111", "abc");
  insertUsers("0922222222", "abc");
  insertUsers("0933333333", "abc");

  //  books
  insertBooks(1, "賈伯斯傳（紀念增訂版", "Walter Isaacson", "人人都知道賈伯斯不遺餘力捍衛隱私，這位傳奇企業家從未寫過回憶錄，但自2009 年起，他接受本書作者艾薩克森多達四十餘次的深入訪談，並允許艾薩克森遍訪他的朋友、親戚、競爭對手、仇人和同事，總數超過一百人。");
  insertBooks(2, "馬斯克傳", "華特．艾薩克森", "除了透過推特、新聞、甚至網路迷因，還有其他方式可以看懂馬斯克嗎？曾操刀《賈伯斯傳》的艾薩克森獲得馬斯克首肯，進入他的童年與精神世界，暴露他無止盡的缺點、以及心靈黑暗的來源。");
  insertBooks(3, "多巴胺國度：在縱慾年代找到身心平衡", "安娜‧蘭布克醫師（Dr. Anna Lembke） ", "多巴胺是一種神經傳導物質，又稱為「腦內啡」，要讓大腦釋放多巴胺很簡單，只要你做一件事情能讓自己開心就行了，像是上網、吃喝玩樂、盡情購物。不過，多巴胺會逐漸減少，需要更多的慾望、更強的刺激才行，也因此讓人愈來愈痛苦。");

  //  inventory
  insertInventory(1, 1)
  insertInventory(2, 2)
  insertInventory(3, 3)

})

const insertUsers = ((phone, password) => {
  var formdata = new FormData();
  formdata.append("phone", phone);
  formdata.append("password", password);

  var requestOptions = {
    method: 'POST',
    body: formdata,
    redirect: 'follow'
  };

  fetch("http://localhost:8080/register", requestOptions)
    .then(response => response.text())
    .then(result => console.log(result))
    .catch(error => console.log('error', error));
})

const insertBooks = ((isbn, name, author, introduction) => {
  var formdata = new FormData();
  formdata.append("isbn", isbn);
  formdata.append("name", name);
  formdata.append("author", author);
  formdata.append("introduction", introduction);

  var requestOptions = {
    method: 'POST',
    body: formdata,
    redirect: 'follow'
  };

  fetch("http://localhost:8080/insert_book", requestOptions)
    .then(response => response.text())
    .then(result => console.log(result))
    .catch(error => console.log('error', error));
})

const insertInventory = ((isbn, bookId) => {
  var formdata = new FormData();
formdata.append("isbn", isbn);
formdata.append("bookId", bookId);

var requestOptions = {
  method: 'POST',
  body: formdata,
  redirect: 'follow'
};

fetch("http://localhost:8080/insert_inventory", requestOptions)
  .then(response => response.text())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));
})

onMounted(() => {
  initialData();


  console.log(Cookies.get('jwt_token'));
  // 移除 "Bearer " 前缀
  const tokenWithoutBearer = Cookies.get('jwt_token').replace('Bearer ', '');
      // 解析JWT Token
      const decodedToken = jwt_decode(tokenWithoutBearer);

      // 获取subject
      const subject = decodedToken.sub;
      console.log('userId:', subject);
});
</script>

<template>
  <VRow class="match-height">
    <!-- <VCol
      cols="12"
      md="4"
    >
      <AnalyticsAward />
    </VCol>

    <VCol
      cols="12"
      md="8"
    >
      <AnalyticsTransactions />
    </VCol>

    <VCol
      cols="12"
      md="4"
    >
      <AnalyticsWeeklyOverview />
    </VCol>

    <VCol
      cols="12"
      md="4"
    >
      <AnalyticsTotalEarning />
    </VCol>

    <VCol
      cols="12"
      md="4"
    >
      <VRow class="match-height">
        <VCol
          cols="12"
          sm="6"
        >
          <AnalyticsTotalProfitLineCharts />
        </VCol>

        <VCol
          cols="12"
          sm="6"
        >
          <CardStatisticsVertical v-bind="totalProfit" />
        </VCol>

        <VCol
          cols="12"
          sm="6"
        >
          <CardStatisticsVertical v-bind="newProject" />
        </VCol>

        <VCol
          cols="12"
          sm="6"
        >
          <AnalyticsBarCharts />
        </VCol>
      </VRow>
    </VCol>

    <VCol
      cols="12"
      md="4"
    >
      <AnalyticsSalesByCountries />
    </VCol>

    <VCol
      cols="12"
      md="8"
    >
      <AnalyticsDepositWithdraw />
    </VCol>

    <VCol cols="12">
      <AnalyticsUserTable />
    </VCol> -->
    <VCol cols="12">
      <h1>Library MGMT landing page</h1>
    </VCol>
    <VCol cols="12">
      <VBtn @click="initialData">
        Insert demo data
      </VBtn>
    </VCol>
  </VRow>
</template>
