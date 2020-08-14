import org.apache.hadoop.hbase.HBaseConfiguration
import org.apache.hadoop.hbase.client.ConnectionFactory

fun main() {
    val conf = HBaseConfiguration.create()
    val conn = ConnectionFactory.createConnection(conf)

    GenerateStoreSales(conn).generate()
}