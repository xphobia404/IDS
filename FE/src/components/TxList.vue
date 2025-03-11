<template>
  <v-container>
    <v-btn color="primary" class="mb-4 mr-2" @click="$router.push('/add-tx')">Add Transaction</v-btn>

    <v-data-table :headers="headers" :items="tx">
      <template #item.actions="{ item }">
        <v-icon @click="openEditDialog(item)" tabindex="0">mdi-pencil</v-icon>
      </template>
    </v-data-table>

    <!-- Dialog untuk edit artikel -->
    <v-dialog v-model="dialog" max-width="600px">
      <v-card>
        <v-card-title>Edit Transaction</v-card-title>
        <v-card-text>
          <TxForm :existingTx="selectedTx" @tx-saved="closeDialog" />
        </v-card-text>
      </v-card>
    </v-dialog>
  </v-container>
</template>

<script>
import { getData, updateTx } from '@/api';
import TxForm from '@/components/TxForm.vue';

export default {
  components: { TxForm },
  data() {
    return {
      tx: [],
      dialog: false,
      selectedTx: null,
      headers: [
        { title: 'ID', value: 'id' },
        { title: 'Product Id', value: 'productId' },
        { title: 'Product Name', value: 'productName' },
        { title: 'Amount', value: 'amount' },
        { title: 'Customer Name', value: 'customerName' },
        { title: 'Status', value: 'status' },
        { title: 'Transaction Date', value: 'transactionDate' },
        { title: 'Create By', value: 'createBy' },
        { title: 'Create On', value: 'createOn' },
        { title: 'Actions', value: 'actions', sortable: false }
      ]
    };
  },
  methods: {
    async fetchData() {
      this.tx = await getData();
    },
    openEditDialog(tx) {
      this.selectedTx = { ...tx };
      this.dialog = true;
    },
    closeDialog() {
      this.dialog = false;
      this.fetchData();
    },
  },
  created() {
    this.fetchData();
  }
};
</script>
