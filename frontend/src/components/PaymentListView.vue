<template>

    <v-data-table
        :headers="headers"
        :items="paymentList"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'PaymentListView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "userId", value: "userId" },
                { text: "reservationId", value: "reservationId" },
                { text: "amount", value: "amount" },
                { text: "payDt", value: "payDt" },
                { text: "refundDt", value: "refundDt" },
            ],
            paymentList : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/paymentLists'))

            temp.data._embedded.paymentLists.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.paymentList = temp.data._embedded.paymentLists;
        },
        methods: {
        }
    }
</script>

